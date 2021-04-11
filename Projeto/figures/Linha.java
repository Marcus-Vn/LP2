package figures;

import java.awt.*;

public class Linha extends Figure {
    public Linha (int x, int y, int w, int h, Color ol) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.ol = ol;

    }

    public void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.ol); 
	g2d.drawLine(this.x,this.y,this.w,this.h); 
        
    }
    
}