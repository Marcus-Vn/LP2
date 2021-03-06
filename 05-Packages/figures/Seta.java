package figures;

import java.awt.*;

public class Seta {
    int x, y;
    int w, h;
    //extensão da ponta
    int l, p;
    //background,outline
    Color bgd, ol;

    public Seta (int x, int y, int w, int h, int l, int p, Color bgd, Color ol) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.l = l;
        this.p = p;
	this.bgd = bgd;
	this.ol = ol;
    }

    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	int[] xValues = { this.x, this.x+this.w, this.x+this.w, this.x+this.p, 
	this.x + this.w, this.x + this.w, this.x};
        int[] yValues = { this.y, this.y, this.l/3, this.h + this.l/2,
	this.l+this.h, this.y + this.h, this.y + this.h};
	
	Polygon seta = new Polygon( xValues, yValues, 7 );
        g2d.setColor(this.bgd);
	g2d.fillPolygon( seta ); 
	g2d.setColor(this.ol); 
	g2d.drawPolygon( seta ); 
        
    }
    
}
