package evoltext;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class EvolTextApplet extends Applet
{
  TextEvolFrame frame = null;
  

  //Initialize the applet
  public void init()
  {
    //this.setSize(new Dimension(640,480));
      //Container contentPane =  this.getContentPane();
      this.setLayout(new BorderLayout());
      frame = new TextEvolFrame();
      //frame.setVisible(true);
      this.add(frame, BorderLayout.CENTER);
  }

 
  //Get Applet information
  public String getAppletInfo()
  {
    return "Applet Information";
  }


  public void destroy() {
    remove(frame);
  }

}
