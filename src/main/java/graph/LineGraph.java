
/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author 
 * @version 1.0
 */
package graph;

import java.awt.*;
import java.util.*;
import java.awt.geom.*;

public class LineGraph extends Canvas
{
  final static double yAxisWidth = 40.0;
  final static double xAxisHeight = 20.0;
  final static double yAxisTickSpace = 20.0;
  final static double xAxisTickSpace = 40.0;
  final static float tickPercent = 0.1f;
  ArrayList views = new ArrayList();
  double xAxisMax = 0.0;
  double xAxisMin = 0.0;
 
  public LineGraph()
  {
  super();
  setBackground(Color.white);
  
  
  }
  
public void add(DataView view)
{
  views.add(view);
}
  
public void paint(Graphics g1d)
{
  
  Graphics2D g = (Graphics2D)g1d;
  g.setColor(Color.blue);
  g.setStroke(new BasicStroke(0));

  Dimension size = getSize();
  
  AffineTransform defaultTransform = g.getTransform();
  AffineTransform defaultToNormaized = new AffineTransform(defaultTransform);

  defaultToNormaized.translate( yAxisWidth , size.height - xAxisHeight);
  defaultToNormaized.scale( 1.0, -1.0);
  defaultToNormaized.scale( size.width - yAxisWidth, size.height - xAxisHeight);
  
  Iterator i = views.iterator();
  while( i.hasNext() )
  {
  DataView view = (DataView) i.next();
  
  AffineTransform defaultToWindow = new AffineTransform(defaultToNormaized);
  defaultToWindow.concatenate( view.getTransform() );
  g.setTransform(defaultToWindow);
  
  GeneralPath p = view.getPath();
  g.draw(p);
  
  AffineTransform windowToDefault = null;
  try
  {
  windowToDefault = defaultToWindow.createInverse();
  }
  catch( NoninvertibleTransformException e ) { System.out.println( e.getMessage() );};
  
  g.setTransform(defaultTransform);
  drawYaxis(g, view , defaultToWindow, windowToDefault );
  //getXAxisRange( view );
  drawXaxis(g, view , defaultToWindow, windowToDefault );
  }
} 


public void update()
{  
  autoSizeAll();
  repaint();
}

public void autoSizeAll()
{  
  Iterator i = views.iterator();
  while( i.hasNext() )
  {
  DataView view = (DataView) i.next();
  view.setBoundsAuto();
  }
}


public Dimension getPreferredSize()
{
return new Dimension(200, 200);
}
 
public void drawYaxis( Graphics2D g, DataView view, 
                       AffineTransform defaultToWindow, AffineTransform windowToDefault )
{    
  Dimension size = getSize();
  double tickWindowSize = yAxisTickSpace * windowToDefault.getScaleY() ;

  GeneralPath p = new GeneralPath();
  
  Font defaultFont = new Font("SansSerif", Font.PLAIN, 10);
  g.setFont(defaultFont);

  float scale = (float) - yAxisTickSpace;
  float offset = (float) (size.height - xAxisHeight);
  float x1 = (float) yAxisWidth - 1.0f;
  float x2 = (float) (yAxisWidth - yAxisWidth * tickPercent);
  int tickCount = (int) Math.round( offset/yAxisTickSpace );
  
  int fontHeight = getFontMetrics(defaultFont).getHeight() ;

  for(int i=0 ; i<=tickCount ; i++)
  {
    float y = i * scale + offset;
    p.moveTo( x1, y);
    p.lineTo( x2, y);
    
    Point2D.Float pt = new Point2D.Float( x1, y );
    windowToDefault.transform(pt,pt);
    
    String s = Double.toString(pt.getY() );
    if( s.length() >= 6 )
      s = s.substring( 0, 5 );
    g.drawString( s, 0.0f,  y + (fontHeight/4) ) ;
  }  
  g.draw(p);
  
}
 
 
public void getXAxisRange(  DataView view )
{ 
  xAxisMax = Math.max( xAxisMax, view.maxXWindow );
  xAxisMin = Math.max( xAxisMin, view.minXWindow );
}

public void drawXaxis( Graphics2D g, DataView view, 
                       AffineTransform defaultToWindow, AffineTransform windowToDefault )
{    
  Dimension size = getSize();
  double tickWindowSize = xAxisTickSpace * windowToDefault.getScaleX() ;

  GeneralPath p = new GeneralPath();
  
  Font defaultFont = new Font("SansSerif", Font.PLAIN, 10);
  g.setFont(defaultFont);

  float scale = (float) xAxisTickSpace;
  float offset = (float) yAxisWidth ;
  float y1 = (float) (size.height - xAxisHeight) + 1.0f;
  float y2 = (float) (y1 + xAxisHeight * tickPercent);
  int tickCount = (int) Math.round( (size.width-yAxisWidth)/xAxisTickSpace );
  
  FontMetrics metrics = getFontMetrics(defaultFont) ;

  for(int i=0 ; i<=tickCount ; i++)
  {
    float x = i * scale + offset;
    p.moveTo( x, y1);
    p.lineTo( x, y2);
    
    Point2D.Float pt = new Point2D.Float( x, y1 );
    windowToDefault.transform(pt,pt);
    
    String s = Double.toString(pt.getX() );
    if( s.length() >= 6 )
      s = s.substring( 0, 5 );
    int length = metrics.stringWidth(s);  
    g.drawString( s, x - length/2 , size.height ) ;
  }  
  g.draw(p);
  
}







  
}