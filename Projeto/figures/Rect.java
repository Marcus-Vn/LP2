package figures;

import java.awt.*;

public class Rect extends Figure {

    Color bgd;

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
        g2d.setColor(this.bgd);
	g2d.fillRect(this.x,this.y,this.w,this.h);
	g2d.setColor(this.ol); 
	g2d.drawRect(this.x,this.y,this.w,this.h); 
        
    }
    
}