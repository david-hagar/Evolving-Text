package evoltext;

/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author
 * @version 1.0
 */

import java.lang.*;
import java.util.*;


public class StringCreature implements Cloneable, Comparator
{
  private StringBuffer str = null;
  private int rating = 0;

  public StringCreature() {
    str = new StringBuffer("" + (char) ('A' + (int)(Math.random()* ('z'-'A'))) );
  }

  public StringBuffer getStr( )
  { return str; }
  
  public void setRating(int rating )
  { this.rating = rating; }
  
  public int getRating( )
  { return rating; }
  
  
  public StringCreature makeNew( StringCreature a, EvolSim sim)
  {
  StringCreature newSC = (StringCreature) this.clone() ;
  
  StringBuffer s1 = this.str;
  StringBuffer s2 = a.str;
  int length = Math.min(s1.length(),s2.length());
  for(int i=0;i<length;i++ )
  {
    newSC.str.setCharAt(i, (Math.random() > 0.5) ? s1.charAt(i) : s2.charAt(i ) );   
  }
  
  newSC.randomize( sim );
  
  while( sim.uniqueStrings.get(newSC.getStr())  != null )
    newSC.randomize(sim);
    
  sim.uniqueStrings.put( newSC.getStr() , "" );
  return newSC;
  }

  
  public StringCreature makeNew( EvolSim sim )
  {
  StringCreature newSC = (StringCreature) this.clone() ;
  newSC.randomize(sim);

  while( sim.uniqueStrings.get( newSC.getStr() ) != null )
    newSC.randomize( sim );

  sim.uniqueStrings.put( newSC.getStr() , "" );
  return newSC;
  }
  
  
  private void randomize( EvolSim sim  )
  {
  int length = str.length();
  int mutationCount = Math.round( length * sim.mutationFraction );
  if( mutationCount == 0 )
    mutationCount= 1;
    
  for(int c=0 ; c<mutationCount ; c++)
  {
    int pos = (int) Math.round( (length-1) * Math.random() );
    int offset = (int) Math.round( (2.0 * Math.random() -1.0) * 3.0 );
    char oldChar = str.charAt(pos);
    int oldCharv = (int) oldChar ;
    char ch = (char) ( oldCharv + offset );
    if( ch<' ' ) ch = ' ';
    if( ch>'~' ) ch = '~';
    str.setCharAt(pos, ch );
  }
  
  if( Math.random() < sim.lengthMutationFraction )
    str.append( 'Z'  );
  
  }
  
  
  public Object clone()
  {
  StringCreature newSC = null;
  try 
   { newSC = (StringCreature) super.clone(); }
  catch (CloneNotSupportedException e)
   { e.printStackTrace(); System.exit(-1); }
   
  newSC.str = new StringBuffer( str.toString() );
  return newSC;
  }
  
  public String toString()
  {
  return str.toString() + " (" + rating + ')';
  }
  
  
  public int compare(Object o1, Object o2) 
  {
  int rating1 = ((StringCreature)o1 ).getRating();
  int rating2 = ((StringCreature)o2 ).getRating();
  
  if(rating1==rating2)
    return 0;
    
  return (rating1 < rating2) ? -1:1 ;
  }
  
 /* public boolean equals(Object obj) 
  {
    return rating == ((StringCreature)obj ).getRating();
  }
  */
}