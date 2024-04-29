package herramientas;




import figuras.*;
import herramientas.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[]args){
        Fondos fondos=new Fondos();
        fondos.setVisible(true);
        
        Colores colores = new Colores();
        Lienzo lienzo = new Lienzo(colores,fondos.getColorF());
       
        Lienzo2 lienzo2=new Lienzo2(colores,fondos.getColorF());
        
         Lienzo3 lienzo3=new Lienzo3(colores,fondos.getColorF());
         
        Cuadrado c = new Cuadrado(lienzo,lienzo2,lienzo3);
        c.graficarCuadrado();
        Circulo cir = new Circulo(lienzo,lienzo2,lienzo3);
        cir.graficarCirculo();
        Linea l = new Linea(lienzo,lienzo2,lienzo3);
        l.graficarLinea();
        
        FigurasGeo fig = new FigurasGeo(lienzo,c, cir,l,lienzo2,lienzo3);

        Pizarra pizarra = new Pizarra(lienzo, colores, fig,lienzo2,lienzo3);
        pizarra.setVisible(true);
        
        Lapiz lapiz = new Lapiz(pizarra,lienzo,lienzo2,lienzo3);
        lapiz.activarLapiz();
        lapiz.rayarConColor();
        lapiz.cambiarGrosor();

        Borrador borrador = new Borrador(pizarra, lienzo,lienzo2,lienzo3);
        borrador.activarBorrador();
        borrador.cambiarTamanio();

        Texto texto = new Texto(pizarra, lienzo,lienzo2,lienzo3);
        texto.insertarTexto();      
        
        Edicion ed = new Edicion(pizarra, lienzo,lienzo2,lienzo3);
        ed.activarGuardar();
        ed.clearAll();
        ed.ponerCuadriculas();
        ed.activarAbrir();

        ed.colorTamañoFigura();
        Imagen im= new Imagen(pizarra,lienzo,lienzo2,lienzo3);
        
    }
}
