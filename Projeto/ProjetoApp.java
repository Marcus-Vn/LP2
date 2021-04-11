import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import figures.*;

class ProjetoApp {
    public static void main (String[] args) {
        ProjetoFrame frame = new ProjetoFrame();
        frame.setVisible(true);
    }
}

class ProjetoFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Iterator<Figure> obj = figs.iterator();
    public Figure focus = null;
    Random rand = new Random();

    ProjetoFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

	this.addMouseListener(new MouseAdapter(){
		public void mousePressed (MouseEvent evt){
			focus = null;
			for(Figure fig: figs){
				if((fig.x <= evt.getX() && fig.x+fig.w >= evt.getX()) 
				&& (fig.y <= evt.getY() && fig.y+fig.h >= evt.getY())){
					focus = fig;
				}
			}
		}
	});

	this.addMouseMotionListener(new MouseMotionAdapter(){
		public void mouseDragged (MouseEvent evt){
		
		}
	});

	this.addKeyListener (
	   new KeyAdapter(){
	      public void keyPressed (KeyEvent evt){
		      int x = MouseInfo.getPointerInfo().getLocation().x;
                      int y = MouseInfo.getPointerInfo().getLocation().y;
                      int w = 50;
                      int h = 50;
		      int l = rand.nextInt(100);
                      int p = h + rand.nextInt(100);
		      Color bgd = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                      Color ol = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
		
		      if (evt.getKeyChar() == 'r') {
			Rect r = new Rect(x,y,w,h,ol,bgd);
                      	figs.add(r);
		      } else if(evt.getKeyChar() == 'e') {
			Ellipse e = new Ellipse(x,y,w,h,ol,bgd);
                      	figs.add(e);
		      } else if(evt.getKeyChar() == 's') {
			Seta s = new Seta(x,y,w,h,l,p,ol,bgd);
                      	figs.add(s);
		      } else if(evt.getKeyChar() == 'l') {
			Linha li = new Linha(x,y,w,h,ol);
                      	figs.add(li);
		      } else if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
			for(Iterator<Figure> iterator = figs.iterator(); iterator.hasNext();){
		        	Figure obj = iterator.next();
				if(obj == focus){
					iterator.remove();
				}
		        }
			
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
