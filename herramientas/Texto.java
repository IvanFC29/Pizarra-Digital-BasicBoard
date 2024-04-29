package herramientas;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Texto 
{
    private Pizarra p;
    private JButton tex;
    private Lienzo canvas;
    private Point punto;
    private Lienzo2 canvas2;
    private Lienzo3 canvas3;
    public Texto(Pizarra p, Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.p = p;
        this.canvas = canvas;
        tex = p.getTexto();
        punto = new Point();
        this.canvas2=canvas2;
         this.canvas3=canvas3;
    }
    public void insertarTexto(){
        tex.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("INSERTANDO TEXTO");
                    canvas.te = true;
                     canvas2.te = true;
                      canvas3.te = true;
                    insertar();
                    canvas.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                     canvas2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                      canvas3.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            });    
    }
    private void insertar() {
            canvas.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    if(canvas.te == true){
                        canvas.cu=false;
                        canvas.cir=false;
                        canvas.rec=false;
                        canvas.tri=false;
                        canvas.te=false;
                        punto = e.getPoint();
                        canvas.escribirTexto(punto);
                    }
                    canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
                }
            });   
            canvas2.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    if(canvas2.te == true){
                        canvas2.cu=false;
                        canvas2.cir=false;
                        canvas2.rec=false;
                        canvas2.tri=false;
                          canvas2.te=false;
                        punto = e.getPoint();
                        canvas2.escribirTexto(punto);
                    }
                    canvas2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
                }
            });   
            canvas3.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    if(canvas3.te == true){
                        canvas3.cu=false;
                        canvas3.cir=false;
                        canvas3.rec=false;
                        canvas3.tri=false;
                        canvas3.te=false;
                        punto = e.getPoint();
                        canvas3.escribirTexto(punto);
                    }
                    canvas3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
                }
            });   
    }
    
}

