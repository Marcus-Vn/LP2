package figures;

import java.awt.*;

public abstract class Figure {
    public abstract void paint (Graphics g);
    public int x, y;
    public int w, h;
    //background,outline
    public Color ol;
    
}