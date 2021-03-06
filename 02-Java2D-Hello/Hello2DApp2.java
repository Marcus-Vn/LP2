import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp2 {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D");
        this.setSize(310, 450);
    }

    public void paint (Graphics g) {
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      int w = getWidth();
      int h = getHeight();
	    g2d.setPaint(Color.black);
	    g2d.fillRect(0,0,w,h);
      g2d.setPaint(Color.yellow);
	    g2d.drawRect(0,h-100,100,100);
	    g2d.fillRect(0,h-100,100,100);
	    g2d.setPaint(Color.magenta);
	    g2d.drawRect(100,h-50,150,50);
	    g2d.fillRect(100,h-50,150,50);
	    g2d.drawRect(150,h-100,50,50);
	    g2d.fillRect(150,h-100,50,50);
	    g2d.setPaint(Color.cyan);
	    g2d.drawRect(250,h-200,50,200);
	    g2d.fillRect(250,h-200,50,200);
	
    }
}
