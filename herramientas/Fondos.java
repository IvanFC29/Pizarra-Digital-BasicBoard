package herramientas;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class Fondos extends JDialog {
    private JButton blanco;
    private JButton negro;
    private JButton verde;
    protected Color color;

    private JLabel label;
    public Fondos(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(Pizarra.class.getResource("/iconos/Pizarra.png")));
        setSize(500,300);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        getContentPane().setLayout(null);

        blanco = new JButton("");
        blanco.setBorder(new MatteBorder(5, 1, 1, 1, (Color) new Color(47, 79, 79)));
        blanco.setBackground(Color.WHITE);
        blanco.setCursor(new Cursor(12));
        blanco.setBounds(222, 169, 60, 23);
        blanco.addActionListener(new ActionListener () {
                @Override 
                public void actionPerformed(ActionEvent e){
                    color=Color.WHITE; 
                    dispose();
                }
            });
        getContentPane().add(blanco);
        
        negro = new JButton("");
        negro.setBorder(new MatteBorder(5, 1, 1, 1, (Color) new Color(47, 79, 79)));
        negro.setBackground(Color.BLACK);
        negro.setCursor(new Cursor(12));
        negro.setBounds(104, 169, 60, 23);
        negro.addActionListener(new ActionListener () {
                @Override 
                public void actionPerformed(ActionEvent e){
                    color=Color.BLACK;
                    dispose();
                }
            });
        getContentPane().add(negro);
        

        verde = new JButton("");
        verde.setBorder(new MatteBorder(5, 1, 1, 1, (Color) new Color(47, 79, 79)));
        verde.setBackground(new Color(0, 128, 0));
        verde.setCursor(new Cursor(12)); 
        verde.setBounds(337, 169, 60, 23);
        verde.addActionListener(new ActionListener () {
                @Override 
                public void actionPerformed(ActionEvent e){
                    color = new Color(34,139,34);
                    dispose();
                }
            }); 
        getContentPane().add(verde);

        JLabel lblBienvenido = new JLabel("BIENVENIDO");
        lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblBienvenido.setBounds(183, 50, 140, 14);
        getContentPane().add(lblBienvenido);

        JLabel lblPorFavorEscoge = new JLabel("Por Favor, Escoge un Color De Fondo");
        lblPorFavorEscoge.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblPorFavorEscoge.setBounds(121, 100, 275, 32);
        getContentPane().add(lblPorFavorEscoge);

        label = new JLabel("");
        label.setIcon(new ImageIcon(Fondos.class.getResource("/iconos/fondo.jpg")));
        label.setBounds(0, 0, 494, 271);
        getContentPane().add(label);       
    }
    public Color getColorF(){
        return color;
    }
}

    
