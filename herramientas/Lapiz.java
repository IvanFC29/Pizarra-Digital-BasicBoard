package herramientas;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Lapiz 
{
    private JButton pencil;
    private JButton red, blue, green, yellow, black, white;
    private Pizarra board;
    private Lienzo canvas;
    private int grosor;
    private Point punto;

    private JComboBox<String> comboPencil;
    private String[] losGrosores;
    private Lienzo2 canvas2;
    private Lienzo3 canvas3;
    public Lapiz(Pizarra board, Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.board = board;
        this.canvas = canvas;
        pencil = board.getLapiz();
        red = board.getRed();
        blue = board.getBlue();
        green = board.getGreen();
        yellow = board.getYellow();
        black = board.getBlack();
        white = board.getWhite();
        grosor = 2;
        punto = new Point();

        comboPencil = board.getComboLapiz();
        losGrosores = board.getGrosores();
        this.canvas2=canvas2;
         this.canvas3=canvas3;
    }

    public void activarLapiz() {
        pencil.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    canvas.actBorrador = false;
                    canvas.actLapiz = true;
                    
                    canvas2.actBorrador = false;
                    canvas2.actLapiz = true;
                    
                    canvas3.actBorrador = false;
                    canvas3.actLapiz = true;
                    System.out.println("Se activo el lapiz");
                    rayar();
                    canvas.setCursor(new Cursor(1));   
                     canvas2.setCursor(new Cursor(1));  
                      canvas3.setCursor(new Cursor(1));  
                }
            });        
    }

    private void rayar() {
         canvas.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    canvas.actualizarPunto(e);
                    //puntos=new Punto();
                    //canvas.listPuntos.add(puntos);                   
                }
        });
        canvas.addMouseMotionListener(new MouseAdapter(){
                @Override
                public void mouseDragged(MouseEvent e){
                    if(canvas.actBorrador == false){
                        //puntos.guardarPuntos(e.getX(),e.getY());  
                        canvas.rayarLapiz(punto, e, grosor);
                    }
                }
        });
            
        //Para el canvas2:
            
        canvas2.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    canvas2.actualizarPunto(e);
                   
                }
            });
        canvas2.addMouseMotionListener(new MouseAdapter(){
                @Override
                public void mouseDragged(MouseEvent e){
                    if(canvas.actBorrador == false){
                        canvas2.rayarLapiz(punto, e, grosor);
                    }
                }
            });
            
        //Para el canvas3:
            
         canvas3.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    canvas3.actualizarPunto(e);
                   
                }
            });
        canvas3.addMouseMotionListener(new MouseAdapter(){
                @Override
                public void mouseDragged(MouseEvent e){
                    if(canvas.actBorrador == false){
                        canvas3.rayarLapiz(punto, e, grosor);
                    }
                }
            });
    }

    public void rayarConColor(){
        JButton [] colores = new JButton[6];
        colores[0] = red;
        colores[1] = blue;
        colores[2] = yellow;
        colores[3] = green;
        colores[4] = black;
        colores[5] = white;
        for(int i = 0; i < 6; i++){
            JButton colorSelect = colores[i];
            colorSelect.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        canvas.actBorrador = false;
                        canvas.cambiarColor(red, blue, green, yellow, black, white, e);
                        canvas.setCursor(new Cursor(1));
                        
                        canvas2.actBorrador = false;
                        canvas2.cambiarColor(red, blue, green, yellow, black, white, e);
                        canvas2.setCursor(new Cursor(1));
                        
                        canvas3.actBorrador = false;
                        canvas3.cambiarColor(red, blue, green, yellow, black, white, e);
                        canvas3.setCursor(new Cursor(1));
                    }
                });   
        }
    }

    public void cambiarGrosor(){
        comboPencil.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(comboPencil.getSelectedItem().equals(losGrosores[0])){
                        setGrosor(2); 
                    }else if(comboPencil.getSelectedItem().equals(losGrosores[1])){
                        setGrosor(5);
                    }else if(comboPencil.getSelectedItem().equals(losGrosores[2])){
                        setGrosor(8);
                    }
                }
            });
    }

    public void setGrosor(int n){
        this.grosor = n;
    }
}
