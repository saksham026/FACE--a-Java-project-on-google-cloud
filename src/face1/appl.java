package face1;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class appl extends JApplet
implements ActionListener
{
JFrame fFrame;

/** Build an applet interface with a menubar. A
* a drop down menu includes Open/Close items
* for opening and closing an instance of ParticleFrame.
**/
public void init () {

int e_id   = Integer.parseInt(getParameter("e_id"));
fFrame = new MainWindow (e_id);
fFrame.setVisible (true);

}
public void actionPerformed (ActionEvent e) {
	int e_id   = Integer.parseInt(getParameter("e_id"));
    String command = e.getActionCommand ();
    if (command.equals ("Close")) {
        close ();
    } else { // Open
        if (fFrame == null) {
            fFrame = new MainWindow (e_id);
            fFrame.setVisible (true);
        }
    }
  } // actionPerformed
 
  /** Close the frame. **/
  void close () {
    fFrame.dispose ();
    fFrame = null;
  } // close
 
} // class FrameApplet