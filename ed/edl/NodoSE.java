package ed.edl;
/**
 * Este Nodo pose unicamente un enlace.
 * solo conoce a su sucesor
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class NodoSE<T>
{
    private T        dato;
    private NodoSE<T> sig;
    public NodoSE(){
        dato = null;
        sig = null;
    }
    public NodoSE(T dato){
        this.dato = dato;
        sig =  null;
    }
    public T getDato(){
        return dato;
    }
    public NodoSE<T> getSig(){
        return sig;
    }
    public void setDato(T x){
        dato = x;
    }
    public void setSig(NodoSE<T> x){
        sig = x;
    }
}
