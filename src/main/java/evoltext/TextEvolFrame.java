package evoltext;
/*
 */

import java.awt.*;
import java.awt.event.*;

public class TextEvolFrame extends Panel {
  BorderLayout borderLayout1 = new BorderLayout();
  Panel jPanel2 = new Panel();
  Panel textOutPanel = new Panel();
  BorderLayout borderLayout3 = new BorderLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  Button resetButton = new Button();
  Panel stopPanel = new Panel();
  Panel topPannel = new Panel();
  Label jLabel5 = new Label();
  TextArea outputTextArea = new TextArea();
  TextField jTextField8 = new TextField();
  EvolSim sim = new EvolSim();
  EvolStatistics stats;
  Button runButton = new Button();
  Panel right = new Panel();
  GridLayout gridLayout1 = new GridLayout(2,1);
  TextField survivalPercentText = new TextField();
  Panel jPanel8 = new Panel();
  Panel jPanel7 = new Panel();
  TextField mutationPercentText = new TextField();
  Panel jPanel3 = new Panel();
  Label jLabel9 = new Label();
  Label jLabel3 = new Label();
  Label jLabel1 = new Label();
  TextField reproBySexPercentText = new TextField();
  GridLayout gridLayout2 = new GridLayout();
  Panel left = new Panel();
  Panel jPanel12 = new Panel();
  Panel jPanel10 = new Panel();
  TextField goalStringText = new TextField();
  BorderLayout borderLayout6 = new BorderLayout();
  BorderLayout borderLayout5 = new BorderLayout();
  Label jLabel8 = new Label();
  TextField bestGuessText = new TextField();
  Label jLabel4 = new Label();
  GridLayout gridLayout3 = new GridLayout();
  TextField popSizeText = new TextField();
  Label jLabel10 = new Label();
  Panel jPanel9 = new Panel();
  TextField updateRateText = new TextField();
  Panel jPanel11 = new Panel();
  Label jLabel7 = new Label();
  Label jLabel6 = new Label();
  Panel graphPanel = new Panel();
  TextField lengthMutationPercentText = new TextField();
  Panel jPanel4 = new Panel();
  Label jLabel2 = new Label();
  GridLayout gridLayout4 = new GridLayout();

  // Construct the frame
  public TextEvolFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  
  stats = new EvolStatistics(graphPanel);
  sim.init("Methinks it is like a weasel");
  updateGUI();
  }

  // Component initialization
  private void jbInit() throws Exception {
    setBackground(Color.lightGray);
    this.setLayout(borderLayout1);
    textOutPanel.setLayout(borderLayout3);
    jPanel2.setLayout(borderLayout4);
    resetButton.setLabel("Reset");
    resetButton.addActionListener(new java.awt.event.ActionListener() {

        public void actionPerformed(ActionEvent e) {
            resetButton_actionPerformed(e);
        }
    });
    topPannel.setLayout(gridLayout2);
    jLabel5.setText("Current Survivors");
    outputTextArea.setSize(new Dimension(57, 300));
    outputTextArea.setText("jTextArea1");
    runButton.setLabel("Run");
    runButton.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        runButton_actionPerformed(e);
      }
    });
    right.setLayout(gridLayout1);
    gridLayout1.setRows(5);
    survivalPercentText.setPreferredSize(new Dimension(50, 21));
    survivalPercentText.setText("10");
    survivalPercentText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        survivalPercentText_actionPerformed(e);
      }
    });
    mutationPercentText.setPreferredSize(new Dimension(50, 21));
    mutationPercentText.setText("2");
    mutationPercentText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        mutationPercentText_actionPerformed(e);
      }
    });
    jLabel9.setText("Survival %");
    jLabel3.setText("Reproduction by Sex  %");
    jLabel1.setText("Mutation %");
    reproBySexPercentText.setPreferredSize(new Dimension(50, 21));
    reproBySexPercentText.setText("10");
    reproBySexPercentText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        reproBySexPercentText_actionPerformed(e);
      }
    });
    jPanel12.setLayout(borderLayout6);
    jPanel10.setLayout(borderLayout5);
    //goalStringText.setPreferredSize(new Dimension(100, 21));
    goalStringText.setText("Monkeys Eat Bannanas");
    goalStringText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        goalStringText_actionPerformed(e);
      }
    });
    jLabel8.setText("Current Best Guess");
    //bestGuessText.setPreferredSize(new Dimension(100, 21));
    bestGuessText.setText("???");
    bestGuessText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        bestGuessText_actionPerformed(e);
      }
    });
    jLabel4.setText("Goal String");
    left.setLayout(gridLayout3);
    gridLayout3.setColumns(1);
    gridLayout3.setRows(3);
    //popSizeText.setToolTipText("");
    popSizeText.setText("100");
    popSizeText.setPreferredSize(new Dimension(50,21));
    popSizeText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        popSizeText_actionPerformed(e);
      }
    });
    popSizeText.setPreferredSize(new Dimension(50, 21));
    jLabel10.setText("Population Size");
    updateRateText.setPreferredSize(new Dimension(40, 21));
    updateRateText.setText("10");
    updateRateText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        updateRateText_actionPerformed(e);
      }
    });
    jLabel7.setText("Generations");
    jLabel6.setText("Update Every");
    graphPanel.setLayout(gridLayout4);
    lengthMutationPercentText.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        lengthMutationPercentText_actionPerformed(e);
      }
    });
    lengthMutationPercentText.setText("2");
    lengthMutationPercentText.setPreferredSize(new Dimension(50, 21));
    jLabel2.setText("Length Mutation %");
    gridLayout4.setColumns(1);
    gridLayout4.setRows(2);
    this.add(jPanel2, BorderLayout.WEST);
    jPanel2.add(textOutPanel, BorderLayout.CENTER);
    textOutPanel.add(jLabel5, BorderLayout.NORTH);
    textOutPanel.add(outputTextArea, BorderLayout.CENTER);
    jPanel2.add(stopPanel, BorderLayout.SOUTH);
    stopPanel.add(runButton, null);
    stopPanel.add(resetButton, null);
    jPanel2.add(topPannel, BorderLayout.NORTH);
    topPannel.add(left, null);
    left.add(jPanel12, null);
    jPanel12.add(jLabel8, BorderLayout.NORTH);
    jPanel12.add(bestGuessText, BorderLayout.CENTER);
    left.add(jPanel10, null);
    jPanel10.add(jLabel4, BorderLayout.NORTH);
    jPanel10.add(goalStringText, BorderLayout.CENTER);
    left.add(jPanel11, null);
    jPanel11.add(jLabel6, null);
    jPanel11.add(updateRateText, null);
    jPanel11.add(jLabel7, null);
    topPannel.add(right, null);
    right.add(jPanel9, null);
    jPanel9.add(jLabel10, null);
    jPanel9.add(popSizeText, null);
    right.add(jPanel8, null);
    jPanel8.add(jLabel9, null);
    jPanel8.add(survivalPercentText, null);
    right.add(jPanel7, null);
    jPanel7.add(jLabel3, null);
    jPanel7.add(reproBySexPercentText, null);
    right.add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    jPanel3.add(mutationPercentText, null);
    right.add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(lengthMutationPercentText, null);
    this.add(graphPanel, BorderLayout.CENTER);
    jPanel9.add(popSizeText, null);
 }



  void jButton5_actionPerformed(ActionEvent e) {
    System.out.println("Pressed");
  }


  void mutationPercentText_actionPerformed(ActionEvent e) {
    sim.mutationFraction = Float.parseFloat( (( TextField ) e.getSource() ).getText() ) /100.0f;
    updateGUI();
  }

  void runButton_actionPerformed(ActionEvent e) {
  int times =  Integer.parseInt( updateRateText.getText() );
  for(int i = 0; i<times ; i++ )
    {
    sim.run();
    stats.updateData(sim);
    }
  updateGUI();
  }




  void resetButton_actionPerformed(ActionEvent e) {
    sim.init( sim.getGoalString() );
    stats.reset();
    updateGUI();
  }

  void goalStringText_actionPerformed(ActionEvent e) {
    sim.setGoalString ( (( TextField ) e.getSource() ).getText() ) ;
    updateGUI();
  }



  void reproBySexPercentText_actionPerformed(ActionEvent e) {
    sim.sexReproductionFraction = Float.parseFloat( (( TextField ) e.getSource() ).getText() ) /100.0f;
    updateGUI();
  }

  void survivalPercentText_actionPerformed(ActionEvent e) {
    sim.SurvivalFraction = Float.parseFloat( (( TextField ) e.getSource() ).getText() ) /100.0f;
    updateGUI();
  }

  void popSizeText_actionPerformed(ActionEvent e) {
    sim.populationSize = Integer.parseInt( (( TextField ) e.getSource() ).getText() );
    sim.init(sim.getGoalString());
    updateGUI();
  }

  void updateGUI()
  {  
  bestGuessText.setText( sim.getTopCreature().toString() );
  goalStringText.setText( sim.getGoalString() );
  mutationPercentText.setText( Float.toString(sim.mutationFraction *100.0f) );
  lengthMutationPercentText.setText( Float.toString(sim.lengthMutationFraction *100.0f) );
  outputTextArea.setText( sim.getPopulationSubList() );
  reproBySexPercentText.setText( Float.toString(sim.sexReproductionFraction *100.0f) );
  survivalPercentText.setText( Float.toString(sim.SurvivalFraction *100.0f) );
  popSizeText.setText( Integer.toString(sim.populationSize) );
  
  stats.updateGUI();
  }


  void bestGuessText_actionPerformed(ActionEvent e)
  {

  }

  void updateRateText_actionPerformed(ActionEvent e)
  {

  }

  void lengthMutationPercentText_actionPerformed(ActionEvent e)
  {
    sim.lengthMutationFraction = Float.parseFloat( (( TextField ) e.getSource() ).getText() ) /100.0f;
    updateGUI();
  }



}
