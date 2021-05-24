import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import figures.*;

class EditorApp {
    public static void main (String[] args) {
        ProjetoFrame frame = new ProjetoFrame();
        frame.setVisible(true);
    }
}

class ProjetoFrame extends JFrame{

    private static final long serialVersionUID = 1L;
    public ArrayList<Figure> figs = new ArrayList<Figure>();
    Iterator<Figure> obj = figs.iterator();
    public Figure focus = null;
    Random rand = new Random();
  
    int cont = 0;
    boolean Bview = false;
    int index = 0;
	
    JPopupMenu mudarCor;
    Point start;

    public ProjetoFrame () {
	
	try {
	    	FileInputStream f = new FileInputStream("proj.bin");
	    	ObjectInputStream o = new ObjectInputStream(f);
	    	this.figs = (ArrayList<Figure>) o.readObject();
	    	o.close();
	    	
	} catch(Exception x) {
	    System.out.println("ERRO!");
	}
		
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                	try {
                		FileOutputStream f = new FileOutputStream("proj.bin");
                    		ObjectOutputStream o = new ObjectOutputStream(f);
                    		o.writeObject(figs);
                    		o.flush();
                    		o.close();                                  		
                	} catch(Exception x) {               		
                	}                	
                    	System.exit(0);
                }
            }
        );       
   	
	this.setTitle("Editor Grafico");
        this.setSize(600, 500);
    
	this.addMouseListener(new MouseAdapter(){
		public void mousePressed (MouseEvent evt){
			start = evt.getPoint();
			focus = null;
			if(getMousePosition() == null){
				return;
			}
				
			if(SwingUtilities.isLeftMouseButton(evt)){
				for(Figure fig: figs){
					if(fig.clicked(getMousePosition().x, getMousePosition().y)){
						focus = fig;
						index = figs.indexOf(fig);
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
					if(fig.clicked(getMousePosition().x,getMousePosition().y)){
						focus = fig;
						index = figs.indexOf(fig);
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
		      if(getMousePosition() != null){
				int x = getMousePosition().x;
                    		int y = getMousePosition().y;		   
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
		        			focus = null;
		        		}
		        	}
		      	}
		      }
		      if(evt.getKeyChar() == 'f') {
		    		  if(index<figs.size()) {
		    			  focus = figs.get(index);
		    			  index++;
		    		  }
		    		  else {
		    			  index = 0;
		    			  focus = figs.get(index);
		    			  index++;
		    		  }
		      }
		      
		      if(evt.getKeyChar() == '+') {
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
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Figure fig: this.figs){
        	if(fig==focus) {
        		fig.paint(g, true);	
        	}
        	else {
        		fig.paint(g, false);
        	}
        }
    }
}

