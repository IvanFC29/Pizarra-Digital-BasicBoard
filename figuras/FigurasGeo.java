package figuras;

import herramientas.Lienzo;
import herramientas.Lienzo2;
import herramientas.Lienzo3;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FigurasGeo implements ActionListener
{
    JMenu formas;
    JMenuItem cuadrado, circulo, recta;
    Cuadrado cuad;
    Circulo cir;
    Linea rect;
    
    Lienzo l;
    Lienzo2 l2;
    Lienzo3 l3;
    public FigurasGeo(Lienzo l, Cuadrado cuad, Circulo cir,  Linea rect,Lienzo2 l2,Lienzo3 l3){
        this.l = l;
        this.cuad = cuad;
        this.cir = cir;
        this.rect = rect;
        iniciarComponentes();
        this.l2=l2;
        this.l3=l3;
    }

    public void iniciarComponentes(){
        formas = new JMenu("Figuras");
        formas.setBounds(9715, 0, 106, 26);
        formas.setIcon(new ImageIcon(FigurasGeo.class.getResource("/iconos/Figuras SR.png")));
        formas.setCursor(new Cursor(12));

        cuadrado = new JMenuItem("Cuadrado");
        cuadrado.setIcon(new ImageIcon(FigurasGeo.class.getResource("/iconos/Cuadrado.png")));
        cuadrado.addActionListener(this);
        formas.add(cuadrado);
        cuadrado.setCursor(new Cursor(12));

        circulo = new JMenuItem("Circulo");
        circulo.setIcon(new ImageIcon(FigurasGeo.class.getResource("/iconos/Circulo.png")));
        circulo.addActionListener(this);
        formas.add(circulo);
        circulo.setCursor(new Cursor(12));

        

        recta = new JMenuItem("Recta");
        recta.setIcon(new ImageIcon(FigurasGeo.class.getResource("/iconos/Recta.png")));
        recta.addActionListener(this);
        formas.add(recta);
        recta.setCursor(new Cursor(12));
    }

    public JMenu getFormas(){
        return this.formas;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Seleccione ua forma");
        l.setCursor(new Cursor(1));
         l2.setCursor(new Cursor(1));
          l3.setCursor(new Cursor(1));
        if(e.getSource().equals(cuadrado)){
            l.setCu(true);
            l.setActLapiz(false);
            
            l2.setCu(true);
            l2.setActLapiz(false);
            
            l3.setCu(true);
            l3.setActLapiz(false);
            System.out.println("Se dibujo un cuadrado");
            cuad.graficarCuadrado();
        }else if(e.getSource().equals(circulo)){
            l.setCir(true) ;
             l2.setCir(true) ;
              l3.setCir(true) ;
            System.out.println("Se dibujo un circulo");
            cir.graficarCirculo();
        
        }else if(e.getSource().equals(recta)){
            l.setREC(true) ;
            l2.setREC(true) ;
            l3.setREC(true) ;
            System.out.println("Se dibujo una recta");
            rect.graficarLinea();
        }
    }
}
