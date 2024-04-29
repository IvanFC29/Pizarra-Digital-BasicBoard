package ed.ednl;

public class Dupla<E>
{
    private E dato;
    private int nivel;
    public Dupla(E dato, int nivel){
        this.dato = dato;
        this.nivel = nivel;
    }
    @Override
    public String toString(){
        return "[" + dato.toString() + "," + nivel + "]";
    }
}
