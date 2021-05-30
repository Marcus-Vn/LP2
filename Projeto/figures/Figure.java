package figures;

import java.awt.*;
import ivisible.*;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
    private static final long serialVersionUID = 1L;
    public int x, y;
    public int w, h;
    //background,outline
    public Color bgd, ol;
    public Figure(int x, int y, int w, int h, Color ol, Color bgd) {
    	this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.ol = ol;
        this.bgd = bgd;    	
    }
    public abstract boolean clicked(int x, int y);
    public void drag (int dx, int dy) {
    	this.x += dx;
    	this.y += dy;
    }
    public void redimension(int d) {
    	this.w += d;
    	this.h += d;
    }
    
}
