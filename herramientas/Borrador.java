package herramientas;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Borrador 
{
    private JButton eraser;
    private int tam;
    private Pizarra board;
    private Lienzo canvas;
    private String [] losTamanios;
    private JComboBox<String> comboEraser;
    private Lienzo2 canvas2;
    private Lienzo3 canvas3;
    public Borrador(Pizarra board, Lienzo canvas,Lienzo2 canvas2,Lienzo3 canvas3){
        this.board = board;
        this.canvas = canvas;
        eraser = board.getBorrador();
        tam = 6;
        comboEraser = board.getComboBorrador();
        losTamanios = board.getTamanios();
        this.canvas2=canvas2;
        this.canvas3=canvas3;
    }

    public void activarBorrador(){
        eraser.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    canvas.actLapiz = false;
                    canvas.actBorrador = true;
                    //Canvas2:
                    canvas2.actLapiz = false;
                    canvas2.actBorrador = true;
                    //Canvas3:
                    canvas3.actLapiz = false;
                    canvas3.actBorrador = true;
                    System.out.println("Se activo el Borrador");
                    borrar();
                }        
            });
    }

    private void borrar() {
        canvas.addMouseMotionListener(new MouseAdapter(){
                public void mouseDragged(MouseEvent e){
                    if(canvas.actBorrador == true){
                        canvas.borrarBorrador(e, tam);
                    }
                }
            }); 
            canvas2.addMouseMotionListener(new MouseAdapter(){
                public void mouseDragged(MouseEvent e){
                    if(canvas2.actBorrador == true){
                        canvas2.borrarBorrador(e, tam);
                    }
                }
            }); 
             canvas3.addMouseMotionListener(new MouseAdapter(){
                public void mouseDragged(MouseEvent e){
                    if(canvas3.actBorrador == true){
                        canvas3.borrarBorrador(e, tam);
                    }
                }
            }); 
    }

    public void cambiarTamanio(){
        comboEraser.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(comboEraser.getSelectedItem().equals(losTamanios[0])){
                        setTam(6);
                    }else if(comboEraser.getSelectedItem().equals(losTamanios[1])){
                        setTam(8);
                    }else if(comboEraser.getSelectedItem().equals(losTamanios[2])){
                        setTam(11);
                    }else if(comboEraser.getSelectedItem().equals(losTamanios[3])){
                        setTam(16);
                    }else if(comboEraser.getSelectedItem().equals(losTamanios[4])){
                        setTam(20);
                    }
                }
            });
    }

    public void setTam(int t){
        this.tam = t;
    }
}
