package ed.ednl;
import ed.edl.*;


/**
 * Write a description of class ArbolN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolN<E>
{
    // instance variables - replace the example below with your own
    private E raiz;
    private Lista<ArbolN<E>>  desc;
    public ArbolN(){
        raiz = null;
        desc = null;
    }
    public ArbolN(E padre, E h){
        ArbolN<E> hijo;
        raiz = padre;
        desc = new ListaSE<ArbolN<E>>();
        hijo = new ArbolN<E>(h);
        desc.insertar(hijo);
    }
    private ArbolN(E p){
        raiz = p;
        desc = new ListaSE<ArbolN<E>>();
    }
    
    public boolean vacio(){
        return raiz == null;
    }
}
