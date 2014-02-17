package evoltext;

/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author 
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
import graph.*;



public class EvolStatistics
{
  LineGraph ratingHistoryGraph = new LineGraph();
  DataSet ratingHistoryData = new DataSet(1.0, 0.0);
  DataView ratingHistoryView = new DataView( ratingHistoryData );

  LineGraph popRatingGraph = new LineGraph();
  DataSet popRatingData = new DataSet(1.0, 0.0);
  DataView popRatingView = new DataView( popRatingData );

  
  public EvolStatistics( Panel parentFrame)
  {
    popRatingView.setBoundsAuto();
    popRatingGraph.add(popRatingView);
    parentFrame.add(popRatingGraph);

    ratingHistoryView.setBoundsAuto();
    ratingHistoryGraph.add(ratingHistoryView);
    parentFrame.add(ratingHistoryGraph);
  }
  
  public void updateData(EvolSim sim)
  {
  ratingHistoryData.add(sim.getTopCreature().getRating());
  
  popRatingData.clear();
  Iterator i = sim.stringCreatures.iterator();
  while( i.hasNext() )
    popRatingData.add( (double) ( ( (StringCreature)i.next() ).getRating() ) );
  }
  
  public void updateGUI(  )
  {
  ratingHistoryGraph.update();
  popRatingGraph.update();
  }

  public void reset()
  {
  ratingHistoryData.clear();
  }
  
}