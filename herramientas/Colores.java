package herramientas;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Colores
{
    private Color colorActual;
    protected JButton boton;

    public Colores(){    
        colorActual = Color.DARK_GRAY;
        boton=new JButton("");
        boton.setIcon(new ImageIcon(Colores.class.getResource("/iconos/Colores.png")));
        boton.setBounds(570+89, 0,48,46);
        boton.setBackground(Color.BLACK);
        boton.setCursor(new Cursor(12));
        /** CREAMOS EL PANEL DEL JColorChooser */
        boton.addActionListener(
            new ActionListener(){     
                public void  actionPerformed(ActionEvent evento){
                    Color colorAux = JColorChooser.showDialog(null,"GAMA DE COLORES",colorActual);    
                    if(colorAux==null)
                        JOptionPane.showMessageDialog(null, "Cancelado");
                    else
                        setColorActual(colorAux); 
                }    
            });
    }

    public void setColorActual(Color colorActual2) {
        colorActual = colorActual2;
    }
    public Color getColorActual(){
        return colorActual;
    }
}
