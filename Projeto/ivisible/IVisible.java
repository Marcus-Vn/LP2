package ivisible;

import java.awt.Graphics;

public interface IVisible {
	public abstract void paint (Graphics g, boolean focused);
	public boolean clicked(int x, int y); 
}
