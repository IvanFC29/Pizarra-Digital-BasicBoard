package figuras;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import herramientas.Lienzo;
import herramientas.Lienzo2;
import herramientas.Lienzo3;
public class Cuadrado {    
    private Lienzo canvas;
    private Lienzo2 canvas2;
     private Lienzo3 canvas3;
    private int x1,y1,x2,y2; //x2 = base, y2 = altura
    public Cuadrado(Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.canvas = canvas;
        this.canvas2 = canvas2;
        this.canvas3 = canvas3;
    }
    public void graficarCuadrado() {
        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1, y1, e); 
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas.getCu() == true){
                    canvas.setCir(false);
                    canvas.setREC(false);
                    canvas.setTri(false);
                    canvas.setCu(false);
                    canvas.setActLapiz(false);
                    
                    x2 = e.getX();
                    y2 = e.getY();
                    Shape cuadrado = new Rectangle2D.Double(x1,y1, x2-x1, y2-y1);
                    canvas.graficarCuadrado(x1, y1, x2,y2,cuadrado, e);
                }
            }
        });
        canvas2.addMouseListener(new MouseAdapter(){
           @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1, y1, e); 
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas2.getCu() == true){
                    canvas2.setCir(false);
                    canvas2.setREC(false);
                    canvas2.setTri(false);
                    canvas2.setCu(false);
                    canvas2.setActLapiz(false);
                    
                    x2 = e.getX();
                    y2 = e.getY();
                    Shape cuadrado = new Rectangle2D.Double(x1,y1, x2-x1, y2-y1);
                    canvas2.graficarCuadrado(x1, y1, x2,y2,cuadrado, e);
                }
            }
        });
        canvas3.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1, y1, e); 
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas3.getCu() == true){
                    canvas3.setCir(false);
                    canvas3.setREC(false);
                    canvas3.setTri(false);
                    canvas3.setCu(false);
                    canvas3.setActLapiz(false);
                    
                    x2 = e.getX();
                    y2 = e.getY();
                    Shape cuadrado = new Rectangle2D.Double(x1,y1, x2-x1, y2-y1);
                    canvas3.graficarCuadrado(x1, y1, x2,y2,cuadrado, e);
                }
            }
        });
    }
}

