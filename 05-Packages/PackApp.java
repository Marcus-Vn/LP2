import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Seta s1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(400, 400);
        this.r1 = new Rect(100,50,50,30,Color.blue,Color.black);
        this.e1 = new Ellipse(80,160,90,90,Color.red,Color.black);
	this.s1 = new Seta(100,100,100,50,150,180,Color.yellow,Color.black);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
	this.s1.paint(g);
    }
}
