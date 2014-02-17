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

public class EvolSim {
  public ArrayList stringCreatures = new ArrayList();
  public Hashtable uniqueStrings = new Hashtable();
  static final int sizePenalyPerChar = 'z' - '0';
  public int populationSize = 100;
  public float mutationFraction = 0.1f;
  public float lengthMutationFraction = 0.01f;
  public float sexReproductionFraction = 0.5f;
  public float SurvivalFraction = 0.1f;
  private String goalString = null;
  private int survivorCuttoff = 0;

  public EvolSim()
  {

  }

  public void init(String goalString)
  {
  this.goalString = goalString;
  stringCreatures = new ArrayList(populationSize);
  uniqueStrings = new Hashtable(populationSize);
  for(int i=0 ; i<populationSize ; i++)
    while(true)
    {
    StringCreature sc = new StringCreature();
    if(uniqueStrings.get(sc.getStr()) == null )
      {
        stringCreatures.add( sc );
        break;
      }
    }
  }

  public void run()
  {
  uniqueStrings = new Hashtable(populationSize* 2);

  // Kill low rated strings
  int size = stringCreatures.size();
  int lowIndex = Math.round( SurvivalFraction*size );
  if( lowIndex == 0 && SurvivalFraction > 0.0 )
    lowIndex = 1;
  if( lowIndex > size )
    lowIndex = size;
  survivorCuttoff = lowIndex;
  
  for(int a=0 ; a<lowIndex ; a++)
  {
    uniqueStrings.put( ( (StringCreature) stringCreatures.get(a) ).getStr() , "" );
  }  
  
  // Make new ones
  int sexCount = Math.round( sexReproductionFraction *(size-lowIndex) );
  int mutationCount = (size-lowIndex) - sexCount ;
  int index = lowIndex;

  // Do sexual reproduction
  for(int a=2 ; a<size ; a++)
  {
    StringCreature c1 = (StringCreature) stringCreatures.get(a);
    for(int b=a-1 ; b>=0 ; b--)
    {
      StringCreature c2 = (StringCreature) stringCreatures.get(b);
      StringCreature new_c =  c1.makeNew(c2, this) ;
      stringCreatures.set( index++, new_c );
      
      if( --sexCount == 0 )
        { a=size; b=0; }  // exit loops
    }
  }

  // Do asexual reproduction
  for(int c=0 ; c<mutationCount ; c++)
    {
      StringCreature creature = (StringCreature) stringCreatures.get(c);
      StringCreature new_c = creature.makeNew( this );
      stringCreatures.set( index++, new_c );
     }
  
  if( index != size )
    System.out.println("Size missmatch " + index + " " + size);

  for(int c=0 ; c<size ; c++)
  {
    rateCreature( (StringCreature) stringCreatures.get( c ) );
  }
  
  Collections.sort(stringCreatures, getTopCreature() ); 

  }

  
  
  public void rateCreature( StringCreature sc )
  {
  StringBuffer guessString = sc.getStr();
  
  int guessLength = guessString.length();
  int goalLength  = goalString.length();
  int minSize = Math.min(guessLength,goalLength);
  int maxSize = Math.max(guessLength,goalLength);
  int rating = 0;
  
  for(int c=0 ; c<minSize ; c++)
  {
    rating+= Math.abs(  ((int)guessString.charAt(c)) - 
                        ((int) goalString.charAt(c)) );
  }
  
  rating+= (maxSize - minSize) * sizePenalyPerChar;
  
  sc.setRating(rating);
  }
  
  
  public StringCreature getTopCreature( )
  {
  return (StringCreature)stringCreatures.get(0);
  }

  
  public String getPopulationSubList( )
  {
  StringBuffer sb = new StringBuffer(1000);
  int size = stringCreatures.size();
  if( size >100 )
    size = 100;
  for(int c=0 ; c<size ; c++)
  {
    sb.append( stringCreatures.get(c).toString() );
    sb.append( '\n' );
  }
  return sb.toString();
  }

  public String getGoalString( )
  { return goalString; }  
  
  public void setGoalString( String goalString )
  { this.goalString = goalString; }  
  

}