import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
	
	this.addKeyListener (
	   new KeyAdapter(){
	      public void keyPressed (KeyEvent evt){
		      int x = rand.nextInt(350);
                      int y = rand.nextInt(350);
                      int w = rand.nextInt(50);
                      int h = rand.nextInt(50);
		      int l = rand.nextInt(100);
                      int p = h + rand.nextInt(100);
		      Color bgd = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                      Color ol = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
		
		      if (evt.getKeyChar() == 'r') {
			Rect r = new Rect(x,y,w,h,bgd,ol);
                      	figs.add(r);
		      } else if(evt.getKeyChar() == 'e') {
			Ellipse e = new Ellipse(x,y,w,h,bgd,ol);
                      	figs.add(e);
		      } else if(evt.getKeyChar() == 's') {
			Seta s = new Seta(x,y,w,h,l,p,bgd,ol);
                      	figs.add(s);
		      }
                      repaint();
	      }
	   }
	);
	
        this.setTitle("Figuras");
        this.setSize(400, 400);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for(Figure fig: this.figs) {
	    fig.paint(g);	
	}
    }
}
