package figures;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class Rect extends Figure {
  	
    Rectangle2D Rect;
    Rectangle2D foco;
	    
    
    public Rect (int x, int y, int w, int h, Color ol, Color bgd) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.ol = ol;
	this.bgd = bgd;

    }

    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	this.Rect = new Rectangle2D.Double(this.x,this.y,this.w,this.h);
        g2d.setStroke(new BasicStroke(2));
	g2d.setColor(this.bgd);
	g2d.fill(this.Rect);
	g2d.setColor(this.ol); 
	g2d.draw(this.Rect);
	       
    }
	

    public boolean contains(MouseEvent evt) {
        if (this.Rect.contains(evt.getPoint())){
            	return true;
	}
	else{ return false;}
    }

    public void drag (int dx, int dy) {

	this.x += dx;
	this.y += dy;
	this.Rect = new Rectangle2D.Double(this.x,this.y,this.w,this.h);
    }

    public void redimension(int d) {
	this.w += d;
	this.h += d;
	this.Rect = new Rectangle2D.Double(this.x,this.y,this.w,this.h);
    }

    public void InFocus(Graphics g){
	Graphics2D focusline = (Graphics2D) g;
	this.foco = new Rectangle2D.Double(this.x-3,this.y-3,this.w+6,this.h+6);
	focusline.setColor(Color.red); 
	focusline.draw(this.foco);	
    }
    
}
