package figures;

import java.awt.*;
import java.awt.event.*;

public abstract class Figure {
    public abstract void paint (Graphics g);
    public int x, y;
    public int w, h;
    //background,outline
    public Color bgd, ol;

    public abstract boolean contains(MouseEvent evt);
    public abstract void drag(int dx, int dy);
    public abstract void redimension(int d);
    public abstract void InFocus (Graphics g);
    
}
