package herramientas;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Cursor;


public class Imagen
{
    private JButton imagen;
    private Pizarra board;
    private Lienzo canvas;
    private Lienzo2 canvas2;
    private Lienzo3 canvas3;
    //private Point punto;
    private int x1,y1,ancho,alto;
    
    public Imagen(Pizarra board,Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.board = board;
        this.canvas = canvas;
        this.canvas2=canvas2;
        this.canvas3=canvas3;
        imagen=board.getButonIm();
        //punto = new Point();

            imagen.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    canvas.actImagen=true;
                    canvas2.actImagen=true;
                    canvas3.actImagen=true;
                    ponerImagen();
                }
            });
    }

    public void ponerImagen(){
            canvas.setCursor(new Cursor(1));
            canvas.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    //canvas.puntoFiguras(x1, y1, e); 
                    x1 = e.getX();
                    y1 = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e){
                    if(canvas.actImagen == true){
                        canvas.actImagen=false;
                        canvas.setCir(false);
                        canvas.setREC(false);
                        canvas.setTri(false);
                        canvas.setCu(false);
                        canvas.setActLapiz(false);
                        canvas.insertarImagen(x1,y1,ancho,alto,e);
                        
                    }
                }
            });
            canvas2.setCursor(new Cursor(1));
            canvas2.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    x1 = e.getX();
                    y1 = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e){
                    if(canvas2.actImagen == true){
                        canvas2.actImagen=false;
                        canvas2.setCir(false);
                        canvas2.setREC(false);
                        canvas2.setTri(false);
                        canvas2.setCu(false);
                        canvas2.setActLapiz(false);
                        canvas2.insertarImagen(x1,y1,ancho,alto,e);
                        
                    }
                }
            });
            canvas3.setCursor(new Cursor(1));
            canvas3.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    x1 = e.getX();
                    y1 = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e){
                    if(canvas3.actImagen == true){
                        canvas3.actImagen=false;
                        canvas3.setCir(false);
                        canvas3.setREC(false);
                        canvas3.setTri(false);
                        canvas3.setCu(false);
                        canvas3.setActLapiz(false);
                        canvas3.insertarImagen(x1,y1,ancho,alto,e);
                        
                    }
                }
            });
    }
}
