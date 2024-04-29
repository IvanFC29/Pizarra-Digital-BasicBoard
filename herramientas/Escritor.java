package herramientas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Escritor extends JDialog implements ChangeListener
{
    private static final long serialVersionUID = 1L;
    /**Variables de guardado de datos*/
    String formato;
    int estilo;
    /**Variables Respuesta*/
    String frase ,formatoRes = "";
    int tamRes = 0;
    int estiloRes = Font.PLAIN;
    /**Componentes requeridos*/
    JComboBox<String> comboFormato; 
    JTextField losTam;
    String[]formatos;
    JTextArea areaDeTexto;
    JRadioButton negrita,cursiva;
    public Escritor() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setUndecorated(true);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(Escritor.class.getResource("/Icono/Texto.png")));
        setBounds(100, 100, 450, 281);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        insertarLabels();

        areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(22,30,383,95);
        areaDeTexto.setLineWrap(true);
        areaDeTexto.setWrapStyleWord(true);
        getContentPane().add(areaDeTexto);

        comboFormato = new JComboBox<String>();
        comboFormato.setBounds(159, 161, 112, 20);
        getContentPane().add(comboFormato);
        formatos = new String[]{"Arial","Agency FB", "Castellar","Lucida Calligraphy","Times New Roman"};
        comboFormato.setModel(new DefaultComboBoxModel<>(formatos));
        
        losTam = new JTextField("14");
        losTam.setBounds(341, 161, 56, 20);
        getContentPane().add(losTam);
        
        negrita = new JRadioButton("Negrita");
        negrita.setBackground(Color.LIGHT_GRAY);
        negrita.setBounds(17, 158, 82, 23);
        negrita.addChangeListener(this);
        getContentPane().add(negrita);

        cursiva = new JRadioButton("Cursiva");
        cursiva.setBackground(Color.LIGHT_GRAY);
        cursiva.setBounds(17, 183, 82, 23);
        cursiva.addChangeListener(this);
        getContentPane().add(cursiva);
        
        definirFormato();
        
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(areaDeTexto.getText() != null)
                    frase = areaDeTexto.getText();
                else
                    frase = "";
                formatoRes = getFormato();
                estiloRes = getEstilo();
                String res1 = losTam.getText();
                try{
                    tamRes = Integer.parseInt(res1);
                }catch(NumberFormatException i){
                    JOptionPane.showMessageDialog(null, "Porfavor, inserte un numero" +"\n"+ "Inicie Nuevamente");
                }
                dispose();
            }
        });
        ok.setBounds(205, 208, 89, 23);
        getContentPane().add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Insercion de Texto Cancelado");
                dispose();
            } 
        });
        cancel.setBounds(316, 208, 89, 23);
        getContentPane().add(cancel);
    }

    private void insertarLabels(){
        JLabel lblEscribaSuTexto = new JLabel("Escriba su texto");
        lblEscribaSuTexto.setFont(new Font("Lucida Fax", Font.BOLD, 13));
        lblEscribaSuTexto.setBounds(165, 11, 169, 14);
        getContentPane().add(lblEscribaSuTexto);

        JLabel lblEstilo = new JLabel("Estilo");
        lblEstilo.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
        lblEstilo.setBounds(22, 136, 46, 14);
        getContentPane().add(lblEstilo);

        JLabel lblFormato = new JLabel("Tipo de Letra");
        lblFormato.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
        lblFormato.setBounds(165, 136, 97, 14);
        getContentPane().add(lblFormato);

        JLabel lblTamao = new JLabel("Tama\u00F1o");
        lblTamao.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
        lblTamao.setBounds(341, 136, 64, 14);
        getContentPane().add(lblTamao);
    }

    /**Definimos el formato(tipo de letra) */
    public void definirFormato(){
        comboFormato.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(comboFormato.getSelectedItem().equals(formatos[0])){
                    setFormato("Arial");
                }else if(comboFormato.getSelectedItem().equals(formatos[1])){
                    setFormato("Agency FB");
                }else if(comboFormato.getSelectedItem().equals(formatos[2])){
                    setFormato("Castellar");
                }else if(comboFormato.getSelectedItem().equals(formatos[3])){
                    setFormato("Lucida Calligraphy");
                }
                else if(comboFormato.getSelectedItem().equals(formatos[4])){
                    setFormato("Times New Roman");
                }
            }
        });
    }
    public String getFormato(){
        return this.formato;
    }
    public void setFormato(String fo){
        this.formato = fo;
    } 
    
    /**Definimos el estilo N,K */
    public void stateChanged(ChangeEvent e){
        if(negrita.isSelected()){
            setEstilo(Font.BOLD); 
        }else if(cursiva.isSelected()){
            setEstilo(Font.ITALIC);
        }
        if(negrita.isSelected() && cursiva.isSelected()){
            setEstilo(Font.BOLD | Font.ITALIC);
        }
    }
    public void setEstilo(int e){
        this.estilo = e;
    }
    public int getEstilo(){
        return this.estilo;
    }
}
