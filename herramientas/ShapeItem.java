package herramientas;

import java.awt.Shape;
import java.awt.Color;
public class ShapeItem {
    private Shape shape;
    private Color color;
    private int x,y,base,altura;
    private String rellenado, descripcion;
    public ShapeItem(Shape shape, Color color, int x, int y, int base, int altura, String rellenado, String descripcion) {
        this.shape = shape;
        this.color = color;
        this.x = x;
        this.y = y;
        this.base = base;
        this.altura = altura;
        this.rellenado = rellenado;
        this.descripcion = descripcion;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getBase(){
        return base;
    }

    public void setX(int n){
        this.x = n;
    }

    public int getAltura(){
        return altura;
    }

    public void setY(int n){
        this.y = n;
    }

    public void setBase(int n){
        this.base = n;
    }

    public void setAltura(int n){
        this.altura = n;
    }

    public String getRellenado(){
        return rellenado;
    }

    public void setRellenado(String r){
        this.rellenado = r;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String r){
        this.descripcion = r;
    }
}