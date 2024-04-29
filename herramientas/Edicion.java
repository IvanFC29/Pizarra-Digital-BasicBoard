package herramientas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.event.*;
public class Edicion
{
    private Lienzo canvas;
    private Pizarra p;
    private JButton btnGuardar,btnAbrir;
    protected JButton clear, botonCC;
    protected JCheckBox cuadricula;
     private Lienzo2 canvas2;

     private Lienzo3 canvas3;
    public Edicion(Pizarra p, Lienzo canvas,Lienzo2 canvas2, Lienzo3 canvas3){
        this.p = p;
        this.canvas = canvas;
        btnGuardar = p.getBtnGuardar();
        clear=p.getClear();
        cuadricula=p.getCuadricula();
        this.canvas2=canvas2;
        btnAbrir=p.getBtnAbrir();
        
        this.canvas3=canvas3;
        botonCC = p.getBotonCC();
    }
    public void clearAll(){
         clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){            
                System.out.println("llll");
                //repaint();
                canvas.repintar();
                canvas2.repintar();
                canvas3.repintar();
            }
        });
        
    }
   
    public void ponerCuadriculas(){
        cuadricula.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){     
                if(cuadricula.isSelected()==true){
                    canvas.pintarCuadriculas(true);
                    if(p.getHoja2()==true)
                    canvas2.pintarCuadriculas(true);
                    if(p.getHoja3()==true)
                    canvas3.pintarCuadriculas(true);
                }else if(cuadricula.isSelected()==false){
                    canvas.pintarCuadriculas(false);
                    //if(p.getHoja2()==false)
                    //canvas2.pintarCuadriculas(false);
                    // canvas3.pintarCuadriculas(false);
                }
            }
        });
        
    }
    
    
    
    public void activarGuardar(){
        btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                canvas.guardar();
                if(p.getHoja2()==true)
                canvas2.guardar();
                if(p.getHoja3()==true)
                canvas3.guardar();
            }
        });
    }    
    public void activarAbrir(){
        btnAbrir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                canvas.abrir();
                if(p.getHoja2()==true)
                canvas2.abrir();
                 if(p.getHoja3()==true)
                canvas3.abrir();
            }
        });
    }    
    public void colorTamañoFigura(){
        canvas.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    canvas.cambiarColorTamaño(e);
                    
                }
            });  
        canvas2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    canvas2.cambiarColorTamaño(e);
                    
                }
            }); 
        canvas3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    canvas3.cambiarColorTamaño(e);
                    
                }
            }); 
    }

}
