import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
 	
    Rect r1,r2,r3,r4;
    public PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Paint");
        this.setSize(350, 350);
	this.r1 = new Rect(150,50,50,30,Color.blue,Color.black);
	this.r2 = new Rect(125,80,100,40,Color.red,Color.blue);
	this.r3 = new Rect(100,120,150,50,Color.yellow,Color.black);
	this.r4 = new Rect(75,170,200,60,Color.green,Color.orange);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
	this.r2.paint(g);
	this.r3.paint(g);
	this.r4.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    //background,outline
    Color bgd, ol;
    Rect (int x, int y, int w, int h, Color bgd, Color ol) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.bgd = bgd;
	this.ol = ol;
    }
    int area () {
	int a = (this.w) * (this.h);
	return a;
    }
    void drag (int dx, int dy) {
	this.x = this.x + dx;
	this.y = this.y + dy;
    }
    void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.bgd);
	g2d.fillRect(this.x,this.y,this.w,this.h);
	g2d.setColor(this.ol); 
	g2d.drawRect(this.x,this.y,this.w,this.h); 
        
    }
    
}
