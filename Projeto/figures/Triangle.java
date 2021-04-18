package figures;

import java.awt.*;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.*;

public class Triangle extends Figure {

    Polygon Triangle;
	
    public Triangle(int x, int y, int w, int h ,Color ol,Color bgd) {
        this.x = x;
        this.y = y;
	this.w = w;
        this.h = h;
	this.ol = ol;
	this.bgd = bgd;
    }

    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	int[] xValues = { this.x, this.x+(this.w/2), this.x+this.w};
        int[] yValues = { this.y+this.h, this.y, this.y + this.h,};
	
	this.Triangle = new Polygon( xValues, yValues, 3);
        g2d.setStroke(new BasicStroke(2));
	g2d.setColor(this.bgd);
	g2d.fill(this.Triangle); 
	g2d.setColor(this.ol); 
	g2d.draw(this.Triangle); 
        
    }
	
    public boolean contains(MouseEvent evt) {
        if (this.Triangle.contains(evt.getPoint())){
            	return true;
	}
	else{ return false;}
    }

    public void drag (int dx, int dy) {
	this.x += dx;
	this.y += dy;
	int[] xValues = { this.x, this.x+(this.w/2), this.x+this.w};
        int[] yValues = { this.y+this.h, this.y, this.y + this.h,};
	this.Triangle = new Polygon( xValues, yValues, 3);
    }
	
    public void redimension (int d) {
	this.w += d;
	this.h += d;
	int[] xValues = { this.x, this.x+(this.w/2), this.x+this.w};
        int[] yValues = { this.y+this.h, this.y, this.y + this.h,};
	this.Triangle = new Polygon( xValues, yValues, 3);
    }
    
}
