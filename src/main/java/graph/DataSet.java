
/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author 
 * @version 1.0
 */
package graph;
import java.util.*;

public class DataSet
{
  private ArrayList data = new ArrayList();
  private double xResolution;
  private double xZero;
  
  public DataSet( double xResolution, double xZero )
  {
  this.xResolution = xResolution;
  this.xZero = xZero;
  }
  
  public double getMaxY()
  {
    if(data.size() == 0)
      return 1.0;
    return ((Double) Collections.max(data) ).doubleValue();
  }
  
  public double getMinY()
  {
    if(data.size() == 0)
      return 0.0;
    return ((Double) Collections.min(data) ).doubleValue();
  }

  public double getMaxX()
  {
    if(data.size() == 0)
      return 1.0;
    return  getX( data.size() -1 );
  }
  
  public double getMinX()
  {
    if(data.size() == 0)
      return 0.0;
    return getX( 0 );
  }

  
  public double getY( int index)
  {
    return ((Double) data.get(index) ).doubleValue();
  }
  
  public double getX( int index)
  {
    return xResolution * index + xZero;
  }
  
  public void add( double value )
  {
     data.add( new Double(value) );
  }

  public int size( )
  {
     return data.size();
  }

  public void clear( )
  {
    data.clear();
  }
  
}