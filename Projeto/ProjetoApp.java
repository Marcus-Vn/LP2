import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import figures.*;

class ProjetoApp {
    public static void main (String[] args) {
        ProjetoFrame frame = new ProjetoFrame();
        frame.setVisible(true);	
    }
}

class ProjetoFrame extends JFrame{
	
    public ArrayList<Figure> figs = new ArrayList<Figure>();
    Iterator<Figure> obj = figs.iterator();
    public Figure focus = null;
    Random rand = new Random();
 
    int cont = 0;
    boolean Bview = false;	
	
    JPopupMenu mudarCor;
    Point start;	

    public ProjetoFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
   	
	this.setTitle("Figuras");
        this.setSize(600, 500);
    
	this.addMouseListener(new MouseAdapter(){
		public void mousePressed (MouseEvent evt){
			start = evt.getPoint();
			focus = null;
			if(SwingUtilities.isLeftMouseButton(evt)){
				for(Figure fig: figs){
					if(fig.contains(evt)){
						focus = fig;					
					}
				}
				if(Bview){
					mudarCor.setVisible(false);
					Bview = false;
					cont-=1;
				}
				if(focus != null){
					figs.remove(focus);
					figs.add(focus);
				}
				repaint();
		
			}
			if(SwingUtilities.isRightMouseButton(evt)){
				for(Figure fig: figs){
					if(fig.contains(evt)){
						focus = fig;
					}
				}
				if(Bview){
					mudarCor.setVisible(false);
					Bview = false;
					cont-=1;
				}
				if(focus != null){
					mudarCor = new JPopupMenu();
					JMenuItem fundoC = new JMenuItem();
					fundoC.setText("Fundo");
					fundoC.addActionListener(
  						new ActionListener() {
   							public void actionPerformed(ActionEvent evtChangeBgd) {
								mudarCor.setVisible(false);
								Bview = false;
								cont -= 1;  
      								JColorChooser color1 = new JColorChooser();
								Color cor1 = JColorChooser.showDialog(null, "Escolha a Cor",focus.bgd);
								if(cor1 != null){
									focus.bgd = cor1;
    								}
								repaint();
  					 		}	
						}
					);
					JMenuItem contornoC = new JMenuItem();
					contornoC.setText("Contorno");
					contornoC.addActionListener(
  						new ActionListener() {
   							public void actionPerformed(ActionEvent evtChangeOl) {
								mudarCor.setVisible(false);
								Bview = false;
								cont -= 1; 
      								JColorChooser color2 = new JColorChooser();
								Color cor2 = JColorChooser.showDialog(null, "Escolha a Cor",focus.ol);
								if(cor2 != null){
									focus.ol = cor2;
    								}
								repaint();							
  					 		}
  					 	}
						
					);
					mudarCor.add(fundoC);
					mudarCor.add(contornoC);
					if(cont == 0){
						mudarCor.show(null, evt.getX(), evt.getY());
						cont += 1;
						Bview = true;
					}
				}
				repaint();	
	       		}
			if(focus== null && Bview){
					mudarCor.setVisible(false);
					Bview = false;
					cont -= 1;
			}	
		}
	});

	this.addMouseMotionListener(new MouseMotionAdapter(){
		public void mouseDragged (MouseEvent evt){
			if(focus != null){
				if(start != null){
					Point Atual = evt.getPoint();
					focus.drag((int)(Atual.getX() - start.x),(int)(Atual.getY() - start.y));
					start = Atual;
					repaint();
				}
			}
			
		
		}
	});

	this.addKeyListener (
	   new KeyAdapter(){
	      public void keyPressed (KeyEvent evt){
		      int x = MouseInfo.getPointerInfo().getLocation().x;
                      int y = MouseInfo.getPointerInfo().getLocation().y;
                      int w = 50;
                      int h = 50;
		      int l = 30;
                      int p = 60;		
		      Color bgd = new Color(255,255,255);
                      Color ol = new Color(0,0,0);
		
		      if (evt.getKeyChar() == 'r') {
			Rect r = new Rect(x,y,w,h,ol,bgd);
                      	figs.add(r);
		      } else if(evt.getKeyChar() == 'e') {
			Ellipse e = new Ellipse(x,y,w,h,ol,bgd);
                      	figs.add(e);
		      } else if(evt.getKeyChar() == 's') {
			Seta s = new Seta(x,y,w,h,l,p,ol,bgd);
                      	figs.add(s);
		      } else if(evt.getKeyChar() == 't') {
			Triangle t = new Triangle(x,y,w,h,ol,bgd);
                      	figs.add(t);
		      } else if(evt.getKeyCode() == KeyEvent.VK_DELETE) {
			for(Iterator<Figure> iterator = figs.iterator(); iterator.hasNext();){
		        	Figure obj = iterator.next();
				if(obj == focus){
					iterator.remove();
				}
		        }
		      }
		      else if(evt.getKeyChar() == '+') {
			if(focus != null){
				focus.redimension(5);
			}
		      }
		      else if(evt.getKeyChar() == '-') {
			if(focus != null && (focus.w >= 6 && focus.h >= 6)){
				focus.redimension(-5);
			}
		      }
		      else if(evt.getKeyCode() == KeyEvent.VK_UP) {
			if(focus != null && focus.y >= 1){
				focus.drag(0,-5);
			}
		      }
		      else if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
			if(focus != null &&  focus.y<= getHeight()-1){
				focus.drag(0, 5);
			}
		      }  
		      else if(evt.getKeyCode() == KeyEvent.VK_LEFT) {
			if(focus != null && focus.x >= 1){
				focus.drag(-5,0);
			}
		      }
		      else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(focus != null && focus.x<= getWidth()-1){
				focus.drag(5,0);
			}
		      }   
                      repaint();
	      }
	   }
	);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for(Figure fig: this.figs) {
	    fig.paint(g);	
	}
    }
}
