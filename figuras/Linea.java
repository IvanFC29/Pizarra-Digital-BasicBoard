package figuras;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import herramientas.Lienzo;
import herramientas.Lienzo2;
import herramientas.Lienzo3;
public class Linea {
    private Lienzo canvas;
    private Lienzo2 canvas2;
     private Lienzo3 canvas3;
    private int x1, x2, y1, y2;
    public Linea(Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.canvas = canvas;
        this.canvas2 = canvas2;
        this.canvas3 =  canvas3;
        
    }
    public void graficarLinea() {
        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1,y1,e);
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas.getREC() == true){
                    canvas.setCir(false);
                    canvas.setCu(false);
                    canvas.setTri(false);
                    canvas.setREC(false);
                    canvas.setActLapiz(false);
                    x2 = e.getX();
                    y2 = e.getY();
                    
                    String [] botones = {"Linea Horizontal", "Linea Vertical"};
                    int ventana = JOptionPane.showOptionDialog(null, "Seleccione una Opcion", "Dibujando Linea", 
                                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                            botones, botones[0]);
                    if(ventana == 0){
                        Shape linea = new Rectangle2D.Double(x1,y1,x2,5);
                        canvas.graficarLinea(x1, y1, x2, y2, linea, "Horizontal");
                    }else if(ventana == 1){
                        Shape linea = new Rectangle2D.Double(x1,y1,5,y2);
                        canvas.graficarLinea(x1, y1, x2, y2, linea, "Vertical");
                        
                    }                                        
                    
                }
            }
        });
        canvas2.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1,y1,e);
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas2.getREC() == true){
                    canvas2.setCir(false);
                    canvas2.setCu(false);
                    canvas2.setTri(false);
                    canvas2.setREC(false);
                    canvas2.setActLapiz(false);
                    x2 = e.getX();
                    y2 = e.getY();
                    
                    String [] botones = {"Linea Horizontal", "Linea Vertical"};
                    int ventana = JOptionPane.showOptionDialog(null, "Seleccione una Opcion", "Dibujando Linea", 
                                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                            botones, botones[0]);
                    if(ventana == 0){
                        Shape linea = new Rectangle2D.Double(x1,y1,x2,5);
                        canvas2.graficarLinea(x1, y1, x2, y2, linea, "Horizontal");
                    }else if(ventana == 1){
                        Shape linea = new Rectangle2D.Double(x1,y1,5,y2);
                        canvas2.graficarLinea(x1, y1, x2, y2, linea, "Vertical");
                        
                    }                                        
                    
                }
            }
        });
        
        canvas3.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1,y1,e);
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas3.getREC() == true){
                    canvas3.setCir(false);
                    canvas3.setCu(false);
                    canvas3.setTri(false);
                    canvas3.setREC(false);
                    canvas3.setActLapiz(false);
                    x2 = e.getX();
                    y2 = e.getY();
                    
                    String [] botones = {"Linea Horizontal", "Linea Vertical"};
                    int ventana = JOptionPane.showOptionDialog(null, "Seleccione una Opcion", "Dibujando Linea", 
                                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                            botones, botones[0]);
                    if(ventana == 0){
                        Shape linea = new Rectangle2D.Double(x1,y1,x2,5);
                        canvas3.graficarLinea(x1, y1, x2, y2, linea, "Horizontal");
                    }else if(ventana == 1){
                        Shape linea = new Rectangle2D.Double(x1,y1,5,y2);
                        canvas3.graficarLinea(x1, y1, x2, y2, linea, "Vertical");
                        
                    }                                        
                    
                }
            }
        });
    }
}

