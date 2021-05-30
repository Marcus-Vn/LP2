package figures;

import java.awt.*;
import java.awt.geom.*;

public class Ellipse extends Figure{
    private static final long serialVersionUID = 1L;
    private Ellipse2D Ellipse;
    private Ellipse2D foco;

    public Ellipse (int x, int y, int w, int h, Color ol, Color bgd) {
        super(x,y,w,h,ol,bgd);
    }

    public void paint (Graphics g, boolean focused) {
    	Graphics2D g2d = (Graphics2D) g;
    	this.Ellipse = new Ellipse2D.Double(this.x,this.y,this.w,this.h);
    	g2d.setStroke(new BasicStroke(2));
    	g2d.setColor(this.bgd);
    	g2d.fill(this.Ellipse);
    	g2d.setColor(this.ol); 
    	g2d.draw(this.Ellipse);
    	if (focused) {
    		Graphics2D focusline = (Graphics2D) g;
    		this.foco = new Ellipse2D.Double(this.x-3,this.y-3,this.w+6,this.h+6);
    		focusline.setColor(Color.red); 
    		focusline.draw(this.foco);
    	}	
    }
    
    public boolean clicked(int x, int y) {
        if (this.Ellipse != null){
        	return this.Ellipse.contains(x,y);
        }
        return false;
    }    
}
