import java.awt.*;
import ivisible.*;
import figures.*;

public class Button implements IVisible {
	private static int bposx = 15; //posição do botão em x
	private static int bposy = 40; //posição do botão em y
	private static int tam = 30;  //tamanho do botão
	private static int figtam = 20; //tamanho da figura
	
	protected int idx; 
	private Figure fig;
	
	public Button (int idx, Figure fig) {
		this.idx = idx;
		this.fig = fig;
		this.fig.x = bposx+5;
		this.fig.y = (idx==3 ? bposy+idx*tam+10:bposy+idx*tam+5);
		this.fig.w = (idx==3 ? figtam-10:figtam);
		this.fig.h = (idx==3 ? figtam-10:figtam);
	}
	public boolean clicked(int x, int y) {
		return x<=bposx+tam && x>=bposx && y>=bposy+this.idx*tam && y<=bposy+tam+this.idx*tam;
	}
	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		if(focused) {
			g2d.setColor(Color.gray);
			g2d.fillRect(bposx,bposy+this.idx*tam,tam,tam);		
		}else {
			g2d.setColor(Color.lightGray);
			g2d.fillRect(bposx,bposy+this.idx*tam,tam,tam);				
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.black);
		g2d.drawRect(bposx,bposy+this.idx*tam,tam,tam);
		this.fig.paint(g, false);
	}
}
