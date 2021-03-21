package figures;

import java.awt.*;

public class Rect {
    int x, y;
    int w, h;
    //background,outline
    Color bgd, ol;

    public Rect (int x, int y, int w, int h, Color bgd, Color ol) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.bgd = bgd;
	this.ol = ol;
    }

    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.bgd);
	g2d.fillRect(this.x,this.y,this.w,this.h);
	g2d.setColor(this.ol); 
	g2d.drawRect(this.x,this.y,this.w,this.h); 
        
    }
    
}
