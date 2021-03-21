import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EllipsePaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
 	
    Ellipse e1,e2,e3;
    public PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Ellipse");
        this.setSize(350, 350);
	this.e1 = new Ellipse(50,100,50,50,Color.white,Color.black);
	this.e2 = new Ellipse(70,110,100,100,Color.red,Color.black);
	this.e3 = new Ellipse(110,140,150,150,Color.yellow,Color.black);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
	this.e2.paint(g);
	this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    //background,outline
    Color bgd, ol;
    Ellipse (int x, int y, int w, int h, Color bgd, Color ol) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.bgd = bgd;
	this.ol = ol;
    }
    void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.bgd);
	g2d.fillOval(this.x,this.y,this.w,this.h);
	g2d.setColor(this.ol); 
	g2d.drawOval(this.x,this.y,this.w,this.h); 
        
    }
    
}
