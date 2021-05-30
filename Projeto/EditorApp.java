import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

import figures.*;

class EditorApp {
    public static void main (String[] args) {
        ProjetoFrame frame = new ProjetoFrame();
        frame.setVisible(true);
    }
}

class ProjetoFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    private ArrayList<Figure> figs = new ArrayList<Figure>();
    private ArrayList<Button> buts = new ArrayList<Button>();
    
    private Figure focus = null;
    private Button butfocus = null;
    //Tamanho inicial das figuras	   
    private int w = 50;
    private int h = 50;
    private int l = 30;
    private int p = 60;		
    private Color bgd = new Color(255,255,255);
    private Color ol = new Color(0,0,0);
  
    private int cont = 0;
    private boolean Bview = false;
    private int index = 0;
	
    private JPopupMenu mudarCor;
    private Point start;

	@SuppressWarnings("unchecked")
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
    
    	buts.add(new Button(0, new Rect(0,0,0,0,Color.black,Color.white)));
   	buts.add(new Button(1, new Ellipse(0,0,0,0,Color.black,Color.white)));
   	buts.add(new Button(2, new Triangle(0,0,0,0,Color.black,Color.white)));
    	buts.add(new Button(3, new Seta(0,0,0,0,5,10,Color.black,Color.white)));
    
	this.addMouseListener(new MouseAdapter(){
		public void mouseClicked (MouseEvent evt){
			butfocus = null;
			if(getMousePosition() == null){
				return;
			}
			for(Button but: buts){
	        	if(but.clicked(getMousePosition().x, getMousePosition().y)) {
	        		butfocus = but;
	        	}
	        }
			repaint();
		}
		public void mousePressed (MouseEvent evt){
			start = evt.getPoint();
			focus = null;
			if(getMousePosition() == null){
				return;
			}			
			if(SwingUtilities.isLeftMouseButton(evt)){
				if(getMousePosition()!= null && butfocus!=null) {
					int x = getMousePosition().x;
				    	int y = getMousePosition().y;	
					if(butfocus.idx == 0) {
						Rect r = new Rect(x,y,w,h,ol,bgd);
	                    			figs.add(r);
	                    			focus = r;
					}
					else if(butfocus.idx == 1) {
						Ellipse e = new Ellipse(x,y,w,h,ol,bgd);
	                    			figs.add(e);
	                    			focus = e;
					}
					else if(butfocus.idx == 2) {
						Triangle t = new Triangle(x,y,w,h,ol,bgd);
	                    			figs.add(t);
	                    			focus = t;
					}
					else if(butfocus.idx == 3) {
						Seta s = new Seta(x,y,w,h,l,p,ol,bgd);
	                    			figs.add(s);
	                    			focus = s;
					}
					butfocus = null;
				}
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
						mudarCor.show(null, getMousePosition().x, getMousePosition().y);
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
		     	if (evt.getKeyChar() == 'r') {
		     		Rect r = new Rect(x,y,w,h,ol,bgd);
                     		figs.add(r);
                     		focus = r;
		      	} else if(evt.getKeyChar() == 'e') {
		      		Ellipse e = new Ellipse(x,y,w,h,ol,bgd);
                    		figs.add(e);
                    		focus = e;
		      	} else if(evt.getKeyChar() == 's') {
		      		Seta s = new Seta(x,y,w,h,l,p,ol,bgd);
                    		figs.add(s);
                    		focus = s;
		      	} else if(evt.getKeyChar() == 't') {
		      		Triangle t = new Triangle(x,y,w,h,ol,bgd);
                    		figs.add(t);
                    		focus = t;
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
		      if(evt.getKeyChar() == 'f' && figs.size()!=0) {
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
	);}

	@Override
    	public void paint(Graphics g) {
        	super.paint(g);
        	for(Figure fig: this.figs){
        	if(fig == focus) {
        		fig.paint(g, true);	
        	}
        	else {
        		fig.paint(g, false);
        	}
        	}
        	for(Button but: this.buts){
        		if(but == butfocus) {
        			but.paint(g, true);	
        		}
        		else {
        			but.paint(g, false);
        		}
        	}
    	}
}



