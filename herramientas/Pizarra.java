package herramientas;

import figuras.FigurasGeo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Pizarra extends JFrame
{
    private Lienzo lienzo;
    private Canvas canvas;
    private Colores colors; 
    private FigurasGeo formas;
    private JButton lapiz;
    private JComboBox<String> comboLapiz;
    private JButton borrador;
    private JComboBox<String> comboBorrador;
    private JButton red, blue, yellow, green, black, white; 
    private JMenuItem cuadrado, circulo, triangulo, recta;
    private JButton texto;
    private String [] grosores, tamanios;
    private JMenuBar menuFormas;
    private JButton btnGuardar,btnAbrir;;
    private int num;
    protected JButton clear;
    protected JCheckBox cuadricula;
    private Lienzo2 lienzo2;
    private Lienzo3 lienzo3;
    private boolean hoja2;
    private boolean hoja3;
    protected JButton butonIm;
    private JButton botonCC;
    
    public Pizarra(Lienzo lienzo, Colores colors, FigurasGeo formas,Lienzo2 lienzo2,Lienzo3 lienzo3) {
        /**CREAMOS VENTANA */
        super("BASIC_BOARD");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Pizarra.class.getResource("/iconos/Pizarra.png")));
        setSize(1280,690);
        getContentPane().setBackground(new Color(184,134,11));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        /**COMPONENTES DEL LAPIZ*/
        lapiz = new JButton("");
        lapiz.setCursor(new Cursor(12));
        lapiz.setContentAreaFilled(false);
        lapiz.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/Lapiz icono.png")));   
        lapiz.setBounds(168, 0, 33, 23);
        getContentPane().add(lapiz);

        grosores = new String[]{"NIV1", "NIV2","NIV3"};
        comboLapiz = new JComboBox<String>();
        comboLapiz.setModel(new DefaultComboBoxModel<String>(grosores));
        comboLapiz.setCursor(new Cursor(12));
        comboLapiz.setBounds(202, 0, 59, 22);
        getContentPane().add(comboLapiz);
        
        /**COMPONENTES DEL BORRADOR*/
        borrador = new JButton("");
        borrador.setCursor(new Cursor(12));
        borrador.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/Borrador icono.png")));
        borrador.setContentAreaFilled(false);
        borrador.setBounds(263, 0, 33, 23);
        getContentPane().add(borrador);

        tamanios = new String[]{"T1","T2","T3","T4","T5"};
        comboBorrador = new JComboBox<String>();
        comboBorrador.setModel(new DefaultComboBoxModel<String>(tamanios));
        comboBorrador.setCursor(new Cursor(12));
        comboBorrador.setBounds(295, 0, 50, 23);
        getContentPane().add(comboBorrador);
         
        clear = new JButton("");
        clear.setBounds(344,0,72,44);
        clear.setBackground(Color.WHITE);
        clear.setIcon(new ImageIcon(Lienzo.class.getResource("/iconos/Borrar Todo.png")));
        clear.setCursor(new Cursor(12));
        getContentPane().add(clear);
        
        /**COMPONENTES DEL LIENZO*/
        cuadricula=new JCheckBox("cuadricula");
        cuadricula.setBounds(75,0,92,23);
        cuadricula.setCursor(new Cursor(12));
        getContentPane().add(cuadricula);
        /*PARA LAS PESTAÑAS DEL LIENZO*/
        /*N controla el numero de pestañas*/ num = 0;
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBounds(27, 45, 1219, 581);
        getContentPane().add(tabbedPane);        
        tabbedPane.addTab("   Hoja   1", null, lienzo, null);
        
         hoja2=false;
         hoja3=false;
         
        JButton botonPlus = new JButton("");
        botonPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indice = 2+num;
                if(num<=1){
                    if(indice == 2){
                        tabbedPane.addTab("   Hoja     " + indice,null, lienzo2,null);
                        hoja2=true;
                    }
                    if(indice == 3){
                        tabbedPane.addTab("   Hoja     " + indice,null, lienzo3,null);
                        hoja3=true;
                    }
                    if(indice == 4){
                        //canvas = (Lienzo) new Canvas();
                        //canvas.setBackground(Color.WHITE);
                        tabbedPane.addTab("   Hoja     " + indice,null,new Canvas(),null);
                        
                    }
                    indice++;  num+=1;
                }
            }
        });
        botonPlus.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/Plus2.png")));
        botonPlus.setCursor(new Cursor(12));
        botonPlus.setBackground(Color.WHITE);
        botonPlus.setBounds(0, 45, 27, 23);
        getContentPane().add(botonPlus);
        
        /**COMPONENTES DE COLOR*/
        botonesDeColor();   
        getContentPane().add(colors.boton);

        /**COMPONENTES DE FIGURAS*/    
        menuFormas = new JMenuBar();
        menuFormas.setBounds(715, 0, 97, 26);
        getContentPane().add(menuFormas);
        menuFormas.add(formas.getFormas());

        /**COMPONENTE TEXTO*/
        texto = new JButton("T");
        texto.setBounds(817, 0, 59,26);
        texto.setBackground(Color.WHITE);
        texto.setForeground(Color.BLUE);
        texto.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 18));
        texto.setCursor(new Cursor(12));
        getContentPane().add(texto);

        /**COMPONENTES DE DESHACER, REHACER, GUARDAR*/
        
        btnGuardar = new JButton("");
        btnGuardar.setCursor(new Cursor(12));
        btnGuardar.setBounds(0, 0, 32, 32); btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/1Guardar.png"))); 
        btnGuardar.setContentAreaFilled(false);
        getContentPane().add(btnGuardar);
       
        
        btnAbrir = new JButton("");
        btnAbrir.setCursor(new Cursor(12));
        btnAbrir.setBounds(32, 0, 32, 32); btnAbrir.setBackground(Color.WHITE);
        btnAbrir.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/Abrir.png"))); 
        btnAbrir.setContentAreaFilled(false);
        getContentPane().add(btnAbrir);
        
         butonIm= new JButton("");
        butonIm.setBounds(884, 0, 48, 26);
        butonIm.setBackground(Color.WHITE);
        butonIm.setContentAreaFilled(false);
        butonIm.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/Imagen.png")));
        getContentPane().add(butonIm);

        botonCC = new JButton(":)");
        botonCC.setBounds(1100, 50, 23,20);
        //getContentPane().add(botonCC);
        /**CREAMOS ETIQUETAS*/
        crearEtiquetas(); 
    }

    private void crearEtiquetas() {
        JLabel lblArchivo = new JLabel("Archivo");
        lblArchivo.setBackground(new Color(169, 169, 169));
        lblArchivo.setHorizontalAlignment(SwingConstants.CENTER);
        lblArchivo.setVerticalAlignment(SwingConstants.BOTTOM);
        lblArchivo.setOpaque(true);
        lblArchivo.setBounds(0, 0, 66, 44);
        getContentPane().add(lblArchivo);
        
        JLabel lblHerramientas = new JLabel("Herramientas");
        lblHerramientas.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas.setBackground(new Color(169, 169, 169));
        lblHerramientas.setOpaque(true);
        lblHerramientas.setVerticalAlignment(SwingConstants.BOTTOM);
        lblHerramientas.setBounds(60, 0, 350, 44);
        getContentPane().add(lblHerramientas);

        JLabel lblColores = new JLabel("Colores");
        lblColores.setOpaque(true);
        lblColores.setBackground(new Color(169, 169, 169));
        lblColores.setHorizontalAlignment(SwingConstants.CENTER);
        lblColores.setVerticalAlignment(SwingConstants.BOTTOM);
        lblColores.setBounds(415, 0, 290, 44);
        getContentPane().add(lblColores);

        JLabel lblInsertar = new JLabel("Insertar");
        lblInsertar.setOpaque(true);
        lblInsertar.setBackground(new Color(169, 169, 169));
        lblInsertar.setHorizontalAlignment(SwingConstants.CENTER);
        lblInsertar.setVerticalAlignment(SwingConstants.BOTTOM);
        lblInsertar.setBounds(703, 0, 241, 44);
        getContentPane().add(lblInsertar);

    }

    private void botonesDeColor() {
        red = new JButton("");
        red.setBackground(Color.WHITE);
        red.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/color rojo.png")));
        red.setBounds(420, 0, 40, 26);
        red.setCursor(new Cursor(12));
        getContentPane().add(red);

        yellow = new JButton("");
        yellow.setBackground(Color.WHITE);
        yellow.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/color amarillo.png")));
        yellow.setBounds(614, 0, 40, 26);
        yellow.setCursor(new Cursor(12));
        getContentPane().add(yellow);

        black = new JButton("");
        black.setBackground(Color.WHITE);
        black.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/color negro.png")));
        black.setBounds(575, 0, 40, 26);
        black.setCursor(new Cursor(12));
        getContentPane().add(black);

        green = new JButton("");
        green.setBackground(Color.WHITE);
        green.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/color verde.png")));
        green.setBounds(459, 0, 40, 26);
        green.setCursor(new Cursor(12));
        getContentPane().add(green);

        blue = new JButton("");
        blue.setBackground(Color.WHITE);
        blue.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/color azul.png")));
        blue.setBounds(498, 0, 40, 26);
        blue.setCursor(new Cursor(12));
        getContentPane().add(blue);

        white = new JButton("");
        white.setBackground(Color.WHITE);
        white.setIcon(new ImageIcon(Pizarra.class.getResource("/iconos/color blanco.png")));
        white.setBounds(536, 0, 40, 26);
        white.setCursor(new Cursor(12));
        getContentPane().add(white);
    }

    public JButton getLapiz(){
        return lapiz;
    }
    public JButton getRed() {
        return red;
    }
    public JButton getBlue() {
        return blue;
    }
    public JButton getYellow() {
        return yellow;
    }
    public JButton getGreen() {
        return green;
    }
    public JButton getBlack() {
        return black;
    }
    public JButton getWhite() {
        return white;
    }
    public JButton getBorrador(){
        return borrador;
    }
    public JButton getTexto(){
        return texto;
    }
    public JComboBox<String> getComboLapiz(){
        return comboLapiz;
    }
    public String[] getGrosores(){
        return grosores;
    }
    public String[] getTamanios(){
        return tamanios;
    }
    public JComboBox<String> getComboBorrador(){
        return comboBorrador;
    }    
    
    public JButton getBtnGuardar(){
        return btnGuardar;
    }
    public JButton getClear(){
        return clear; 
    }
    
    public JCheckBox getCuadricula(){
        return cuadricula;   
    }
    public JButton getBtnAbrir(){
        return btnAbrir;
     }
     public boolean getHoja2(){
         return hoja2;
        }
        public boolean getHoja3(){
         return hoja3;
        }
        public JButton getButonIm(){
         return butonIm;   
        }
    public JButton getBotonCC(){
        return botonCC;
    }    
        }
     
