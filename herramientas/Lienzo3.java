package herramientas;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.List;
public class Lienzo3 extends Canvas
{
    List<ShapeItem> shapes = new ArrayList<ShapeItem>();
    private int grosor;
    private static final long serialVersionUID = 1L;
    private Color fondo;
    private Point punto, puntof;
    private Graphics2D g2d;
    private Colores color;
    protected BufferedImage image;
    BufferedImage imagenClon;

    protected boolean actLapiz, actBorrador, cu, tri, rec, cir, te, reh, desh,actImagen;

    
    public Lienzo3(Colores color,Color fondo){
        List<ShapeItem> shapes = new ArrayList<ShapeItem>();
        /**CREAMOS lienzo(CANVAS)*/ 
        setBounds(33, 44, 1204, 580);
        this.fondo=fondo;
        setBackground(fondo);

        this.color = color;
        punto = new Point();
        puntof = new Point();

        this.image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        /**Controladores de componentes*/
        actLapiz = false; actBorrador = false; cu=false; tri=false; rec=false; cir=false; te = false;actImagen=false;
    }

    public void cambiarColor(JButton red, JButton blue, JButton green, JButton yellow, JButton black, JButton white, ActionEvent e) {
        if(e.getSource().equals(red)){
            color.setColorActual(Color.RED); 
        }else if(e.getSource().equals(blue)){
            color.setColorActual(Color.BLUE); 
        }else if(e.getSource().equals(green)){
            color.setColorActual(Color.GREEN); 
        }else if(e.getSource().equals(yellow)){
            color.setColorActual(Color.YELLOW); 
        }else if(e.getSource().equals(black)){
            color.setColorActual(Color.BLACK); 
        }else if(e.getSource().equals(white)){
            color.setColorActual(Color.WHITE); 
        }
    }

    /**
     * Limpiar Todo*/
    protected void repintar(){
        this.image = (BufferedImage)this.createImage(this.getWidth(), this.getHeight());
        this.actualizarLienzo();
    }

    /**
     * Poner El Cuadriculado*/
    public void pintarCuadriculas(boolean estado){
        Graphics g = this.getGraphics();
        g2d = (Graphics2D) g;
        if(estado){
            if(fondo==Color.BLACK)
                g2d.setColor(Color.GRAY);
            else
                g2d.setColor(Color.LIGHT_GRAY);
        }else if(!estado){
            g2d.setColor(getBackground());
        }
        for(int i = 1; i < 30 ; i++){
            int b = 25*i;
            g2d.drawLine(0,b,1201,b);
        }
        for(int j = 1; j< 50 ; j++){
            int a = 25*j;
            g2d.drawLine(a,0,a,576);
        }  
        this.actualizarLienzo();
    }

    /**
     * Para el funcionamiento del Lapiz*/
    public void actualizarPunto(MouseEvent e) {
        punto.setLocation(e.getPoint());
    }

    public void rayarLapiz(Point punto2, MouseEvent e, int grosor) {
        Graphics g = image.getGraphics();
        g2d = (Graphics2D)g;
        g2d.setColor(color.getColorActual());
        g2d.setStroke(new BasicStroke(grosor));

        g2d.drawLine(punto.x, punto.y, e.getX(), e.getY());
        punto.setLocation(e.getPoint());

        this.actualizarLienzo();
    }

    /**
     * Para que no se pierda lo que hacemos en la pizarra*/
    private void actualizarLienzo() {
        Graphics graficoLienzo = getGraphics();
        graficoLienzo.drawImage(image, 0,0, this.getWidth(), this.getHeight(), null);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image,0,0,this.getWidth(), this.getHeight(), null);
    }

    /**
     * Para el borrador*/
    public void borrarBorrador(MouseEvent e, int tam) {
        Graphics g = image.getGraphics();
        g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(tam));
        g2d.setColor(fondo);
        g2d.drawRect(e.getX(),e.getY(),tam,tam);
        this.actualizarLienzo();       
    }

    /**
     * Para el texto*/
    public void escribirTexto(Point punto2) {
        Graphics g = image.getGraphics();
        g2d = (Graphics2D) g;

        Escritor escrito = new Escritor();
        escrito.setModal(true);//para que no me deje hacer nada en otra pizarra
        escrito.setVisible(true);

        g2d.setColor(color.getColorActual());
        g2d.setFont(new Font(escrito.formatoRes, escrito.estilo, escrito.tamRes));
        g2d.drawString(escrito.frase, punto2.x, punto2.y);
        this.actualizarLienzo();
    }

    /**
     * Graficamos las figuras */
    /** 
       *  EMPEZAMOS A GRAFICAR FIGURAS
       * @Param:  4 enteros que representan las posiciones en x,y, largo y alto de la figura, 
                  1 objeto de tipo Shape : que es la figura que se dibujara, 
                  El evento del mouse
       *Todos los parametros vienen del paquete Figuras (Ahi estan las respectivas clases y metodos para mandar a dibujar las 
       *figuras) por tanto estos parametros vienen de las clases Cuadrado, Circulo, Linea
        *
        *@NOTA: Ya se puede dibujar la figura solo con el parametro Shape 
         Los demas parametros ayudan para el funcionamiento del REDO, UNDO*/
    public void graficarLinea(int i1, int i2, int j1, int j2, Shape linea, String tipo) {
        Graphics g = image.getGraphics();
        g2d = (Graphics2D) g;
        g2d.setColor(color.getColorActual());
        
        String valor = JOptionPane.showInputDialog(null, "Cuanto de Grosor quiere?", "Dibujando Linea",
                JOptionPane.QUESTION_MESSAGE);
            grosor = Integer.parseInt(valor);
            g2d.setStroke(new BasicStroke(grosor));
         g2d.draw(linea);
        
         if(tipo == "Horizontal"){
            shapes.add(new ShapeItem(linea,color.getColorActual(), i1,i2,j1,j2, "Sin Relleno", "LineaH")); 
         }else if(tipo == "Vertical"){
            shapes.add(new ShapeItem(linea,color.getColorActual(), i1,i2,j1,j2, "Sin Relleno", "LineaV")); 
         }
        
        this.actualizarLienzo();
    }
    public void graficarCuadrado(int xIni, int yIni, int base, int altura, Shape cuadrado, MouseEvent e) {       
        Graphics g = image.getGraphics();
        g2d = (Graphics2D) g; 
        g2d.setColor(color.getColorActual());
        int seleccion = JOptionPane.showConfirmDialog(null, "Cuadro con Relleno?", "Dibujando Cuadrado", JOptionPane.YES_NO_OPTION);
        if(seleccion == 1){
            String valor = JOptionPane.showInputDialog(null, "Cuanto de Grosor quiere?", "Dibujando Cuadrado",
                JOptionPane.QUESTION_MESSAGE);
            grosor = Integer.parseInt(valor);
            g2d.setStroke(new BasicStroke(grosor));
            g2d.draw(cuadrado);
            shapes.add(new ShapeItem(cuadrado,color.getColorActual(), xIni,yIni,base,altura, "Sin Relleno", "Cuadrado")); 
            System.out.println("shapes.add(cuadrado)");
        }else if(seleccion == 0){
            g2d.fill(cuadrado);
         shapes.add(new ShapeItem(cuadrado,color.getColorActual(), xIni,yIni,base,altura, "Con Relleno", "Cuadrado")); 
        } 
       
        this.actualizarLienzo();
    }
    public void graficarCirculo(int xIni, int yIni, int radio1, int radio2, Shape circulo, MouseEvent e) {
        Graphics g = image.getGraphics();
        g2d = (Graphics2D) g;
        g.setColor(color.getColorActual());
        
        int seleccion = JOptionPane.showConfirmDialog(null, "Circulo con Relleno?", "Dibujando Circulo", JOptionPane.YES_NO_OPTION);
        if(seleccion == 1){
            String valor = JOptionPane.showInputDialog(null, "Cuanto de Grosor quiere?", "Dibujando Circulo",
                JOptionPane.QUESTION_MESSAGE);
             grosor = Integer.parseInt(valor);
            g2d.setStroke(new BasicStroke(grosor));
            g2d.draw(circulo);
            shapes.add(new ShapeItem(circulo,color.getColorActual(), xIni,yIni,radio1,radio2, "Sin Relleno", "Circulo")); 
        }else if(seleccion == 0){
            g2d.fill(circulo);
            shapes.add(new ShapeItem(circulo,color.getColorActual(), xIni,yIni,radio1,radio2, "Con Relleno", "Circulo")); 
        }
       
        this.actualizarLienzo();
    }

    public void cambiarColorTamaño(MouseEvent e){
        for (ShapeItem item : shapes) {
            if (item.getShape().contains(e.getPoint())) {
                JOptionPane.showMessageDialog(null, "Selecciono una figura");
                if(item.getRellenado() == "Con Relleno"){
                    String [] botones = {"Cambiar Color", "Cambiar Tamaño"};
                    int ventana = JOptionPane.showOptionDialog(null, "Seleccione una Opcion", "Figura Seleccionada", 
                                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                            botones, botones[0]);
                    if(ventana == 0){
                        Color colorAux = JColorChooser.showDialog(null,"GAMA DE COLORES",color.getColorActual()); 
                        if(colorAux==null)
                            JOptionPane.showMessageDialog(null, "Cancelado");
                            else
                            item.setColor(colorAux);
                    }else if(ventana == 1){
                        String nAltura = JOptionPane.showInputDialog(null, "Ingrese el nuevo Largo", "Cambiando Tamaño", JOptionPane.QUESTION_MESSAGE);
                        String nLargo = JOptionPane.showInputDialog(null, "Ingrese la nueva Altura", "Cambiando Tamaño", JOptionPane.QUESTION_MESSAGE);
                        if(item.getDescripcion() == "Cuadrado"){
                            item.setShape(new Rectangle2D.Double(item.getX(), item.getY(), Integer.parseInt(nLargo), Integer.parseInt(nAltura)));
                        }else if(item.getDescripcion() == "Circulo"){
                            item.setShape(new Ellipse2D.Double(item.getX(), item.getY(), Integer.parseInt(nLargo), Integer.parseInt(nAltura)));
                        }
                    }
                    else if(ventana==2){                   
                        String valor = JOptionPane.showInputDialog(null, "Cuanto de Grosor quiere?", "Dibujando Circulo",
                        JOptionPane.QUESTION_MESSAGE);                  
                        grosor = Integer.parseInt(valor);
                        g2d.setStroke(new BasicStroke(grosor));
                        Graphics g = image.getGraphics();
                        g2d = (Graphics2D) g; 
                    }
                    
                }else if(item.getRellenado() == "Sin Relleno"){
                    String [] botones = {"Cambiar Color", "Cambiar Tamaño","Cambiar Grosor"};
                    int ventana = JOptionPane.showOptionDialog(null, "Seleccione una Opcion", "Figura Seleccionada", 
                                                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                            botones, botones[0]);//vent
                    if(ventana == 0){
                        Color colorAux = JColorChooser.showDialog(null,"GAMA DE COLORES",color.getColorActual()); 
                        if(colorAux==null)
                            JOptionPane.showMessageDialog(null, "Cancelado");
                            else
                            item.setColor(colorAux);
                    }else if(ventana == 1){
                        if(item.getDescripcion() == "Cuadrado" || item.getDescripcion() == "Circulo"){
                            String nAltura = JOptionPane.showInputDialog(null, "Ingrese el nuevo Largo", "Cambiando Tamaño", JOptionPane.QUESTION_MESSAGE);
                            String nLargo = JOptionPane.showInputDialog(null, "Ingrese la nueva Altura", "Cambiando Tamaño", JOptionPane.QUESTION_MESSAGE);//opci 
                            if(item.getDescripcion() == "Cuadrado"){
                                item.setShape(new Rectangle2D.Double(item.getX(), item.getY(), Integer.parseInt(nLargo), Integer.parseInt(nAltura)));
                            }else if(item.getDescripcion() == "Circulo"){
                                item.setShape(new Ellipse2D.Double(item.getX(), item.getY(), Integer.parseInt(nLargo), Integer.parseInt(nAltura)));
                            }
                        }else if(item.getDescripcion() == "LineaH" || item.getDescripcion() == "LineaV"){
                            String nLargo = JOptionPane.showInputDialog(null, "Ingrese la nueva Medida", "Cambiando Tamaño", JOptionPane.QUESTION_MESSAGE);//opci 
                            if(item.getDescripcion() == "LineaH"){
                                item.setShape(new Rectangle2D.Double(item.getX(), item.getY(), Integer.parseInt(nLargo), 3));
                            }else if(item.getDescripcion() == "LineaV"){
                                item.setShape(new Rectangle2D.Double(item.getX(), item.getY(), 3, Integer.parseInt(nLargo)));
                            } 
                        } 
                    }
                    else if(ventana==2){                   
                        String valor = JOptionPane.showInputDialog(null, "Cuanto de Grosor quiere?", "Dibujando Circulo",
                        JOptionPane.QUESTION_MESSAGE);                  
                        grosor = Integer.parseInt(valor);
                        g2d.setStroke(new BasicStroke(grosor));
                        Graphics g = image.getGraphics();
                        g2d = (Graphics2D) g; 
                    }
                }
                }               
            }
        
        Graphics g = image.getGraphics();
        g2d = (Graphics2D) g;
        for (ShapeItem item : shapes) {
            g2d.setColor(fondo);
            g2d.setStroke(new BasicStroke(grosor));
            g2d.drawRect(item.getX(), item.getY(), item.getBase(), item.getAltura());
             //g2d.drawRect(item.getX(), item.getY(), item.getAltura()+grosor, item.getAltura()+grosor);
            g2d.fillRect(item.getX(), item.getY(), item.getBase()+grosor, item.getBase()+grosor);
            g2d.fillRect(item.getX(), item.getY(), item.getAltura()+grosor, item.getAltura()+grosor);
            g2d.setStroke(new BasicStroke(grosor));
            g2d.setColor(item.getColor());
            if(item.getRellenado() == "Con Relleno"){
                g2d.fill(item.getShape()); 
            }else if (item.getRellenado() == "Sin Relleno"){
                g2d.draw(item.getShape());
            }
        }
        this.actualizarLienzo();
    }
    /**
     * REHACER, DESHACER, GUARDAR, ABRIR*/
    

    public void guardar(){
        JFileChooser selector = new JFileChooser();
        selector.showSaveDialog(this);
        File f = selector.getSelectedFile();
        if(f== null){
            return;
        }
        File archivoDestino= new File(f.getParent(), f.getName() + ".png");
        try{
            ImageIO.write(image, "png", archivoDestino);
        }
        catch (java.io.IOException ioe){
            //ioe.printStackTrace();
        }
    }

    public void abrir(){
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File f = selector.getSelectedFile();
        if(f== null){
            return;
        }
        try{
            image=ImageIO.read(f);

        }catch(IOException ex){
        }
        this.actualizarLienzo();
    }
    
    public void insertarImagen(int x1, int y1,int ancho,int alto,MouseEvent e){
        ancho=e.getX();
        alto=e.getY();
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        String archivo =selector.getSelectedFile().getPath();
        Image i= null;
        try{
            i=ImageIO.read(new File(archivo));
        }catch(IOException ex){
        }
        Graphics g = image.getGraphics();
        g2d = (Graphics2D) g;
        g2d.setColor(color.getColorActual());
        g2d.drawImage(i,x1, y1, ancho-x1, alto-y1, null);
        this.actualizarLienzo();
    }

    public boolean getCu(){
        return cu;
    }

    public boolean getTri(){
        return tri;
    }

    public boolean getREC(){
        return rec;
    }

    public boolean getCir(){
        return cir;
    }

    public void setCu(boolean c){
        this.cu=c;
    }

    public void setTri(boolean c){
        this.tri=c;
    }

    public void setREC(boolean c){
        this.rec=c;
    }

    public void setCir(boolean c){
        this.cir=c;   
    }

    public void setActLapiz(boolean c){
        this.actLapiz=c;   
    }

}