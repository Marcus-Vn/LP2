package figures;

import java.awt.*;
import java.awt.event.*;

public class Seta extends Figure {

    Polygon Seta;
    Polygon foco;	

    //extensão da ponta
    int l, p;

    public Seta (int x, int y, int w, int h, int l, int p, Color ol, Color bgd) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.l = l;
        this.p = p;
	this.ol = ol;
	this.bgd = bgd;
    }

    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	int[] xValues = { this.x, this.x+this.w, this.x+this.w, this.x+this.w+this.p, 
	this.x + this.w, this.x + this.w, this.x};
        int[] yValues = { this.y, this.y, this.y - this.l, this.y + this.h/2,
	this.l+this.h+this.y, this.y + this.h, this.y + this.h};
	
	this.Seta = new Polygon( xValues, yValues, 7 );
        g2d.setStroke(new BasicStroke(2));
	g2d.setColor(this.bgd);
	g2d.fill(this.Seta); 
	g2d.setColor(this.ol); 
	g2d.draw(this.Seta); 
        
    }
	
    public boolean contains(MouseEvent evt) {
        if (this.Seta.contains(evt.getPoint())){
            	return true;
	}
	else{ return false;}
    }

    public void drag (int dx, int dy) {
	this.x += dx;
	this.y += dy;	
    }

    public void redimension(int d) {
	this.w += d;
	this.h += d;
	if(d < 0){
		if(this.p >= 6 && this.l >=6){
			this.p += d;
			this.l += d;
		}
	}else{
		this.p += d;
		this.l += d;
	}
    }
	
    public void InFocus(Graphics g){
	Graphics2D focusline = (Graphics2D) g;
	int[] xValues = { this.x-3, this.x+this.w-3, this.x+this.w-3,this.x+this.w, this.x+this.w+this.p+6, 
	this.x + this.w,this.x + this.w-3, this.x + this.w-3, this.x-3};
        int[] yValues = { this.y-3, this.y-3, this.y - this.l-6,this.y - this.l-6, this.y + this.h/2,
	this.l+this.h+this.y+6,this.l+this.h+this.y+6, this.y + this.h+3, this.y + this.h+3};
	this.foco = new Polygon( xValues, yValues, 9 );
	focusline.setColor(Color.red); 
	focusline.draw(this.foco);	
    }
    
}
