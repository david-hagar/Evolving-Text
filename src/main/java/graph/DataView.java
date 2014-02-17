
/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author 
 * @version 1.0
 */
package graph;

import java.awt.geom.*;
import java.lang.*;


public class DataView
{
  DataSet data;
  double minXWindow = -1.0;
  double maxXWindow = 1.0;
  double minYWindow = -1.0;
  double maxYWindow = 1.0;
  AffineTransform transform = new AffineTransform();
  
  public DataView( DataSet data)
  {
  this.data = data;
  }

  public void setBoundsAuto()
  {
  minXWindow = data.getMinX();
  maxXWindow = data.getMaxX();
  minYWindow = data.getMinY();
  maxYWindow = data.getMaxY();
  
  reCalcTransform();
  }

  private void reCalcTransform(  )
  {
  transform = new AffineTransform();
  
  transform.scale( 1.0/(maxXWindow - minXWindow), 1.0/(maxYWindow - minYWindow) );
  transform.translate( -minXWindow, -minYWindow );
  }

  public AffineTransform getTransform(  )
  {
  return transform;
  }

  public int size(  )
  {
  return data.size();
  }

  public GeneralPath getPath()
  {
  GeneralPath p = new GeneralPath();
  int size = size();
  if( size == 0)
    return p;
  
  p.moveTo((float)data.getX(0), (float)data.getY(0) );
  for(int i=1;i<size;i++)
  {
    p.lineTo((float)data.getX(i), (float)data.getY(i) );
  }
  return p;
  }
  
}