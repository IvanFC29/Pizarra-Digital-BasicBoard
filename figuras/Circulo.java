package figuras;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import herramientas.Lienzo;
import herramientas.Lienzo2;
import herramientas.Lienzo3;
public class Circulo 
{
    private Lienzo canvas;
    private Lienzo2 canvas2;
    private Lienzo3 canvas3;
    private int x1,x2,y1,y2;
    public Circulo(Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.canvas = canvas;
        this.canvas2 = canvas2;
        this.canvas3 = canvas3;
    }
    public void graficarCirculo() {
        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //canvas.puntoFiguras(x1, y1, e);
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(canvas.getCir() == true){
                    canvas.setCu(false);
                    canvas.setTri(false);
                    canvas.setREC(false);
                    canvas.setCir(false);        
                    canvas.setActLapiz(false);
                    
                    x2 = e.getX();
                    y2 = e.getY();
                    Shape circulo = new Ellipse2D.Double(x1, y1, x2-x1, y2-y1);
                    canvas.graficarCirculo(x1,y1,x2,y2,circulo,e);
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
                if(canvas2.getCir() == true){
                    canvas2.setCu(false);
                    canvas2.setTri(false);
                    canvas2.setREC(false);
                    canvas2.setCir(false);        
                    canvas2.setActLapiz(false);
                    
                    x2 = e.getX();
                    y2 = e.getY();
                    Shape circulo = new Ellipse2D.Double(x1, y1, x2-x1, y2-y1);
                    canvas2.graficarCirculo(x1,y1,x2,y2,circulo,e);
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
                if(canvas3.getCir() == true){
                    canvas3.setCu(false);
                    canvas3.setTri(false);
                    canvas3.setREC(false);
                    canvas3.setCir(false);        
                    canvas3.setActLapiz(false);
                    
                    x2 = e.getX();
                    y2 = e.getY();
                    Shape circulo = new Ellipse2D.Double(x1, y1, x2-x1, y2-y1);
                    canvas3.graficarCirculo(x1,y1,x2,y2,circulo,e);
                }
            }
        });
    }
}

