package ed.edl;


/**
 * Una cola es una estructura en donde el primer elemento entrar
 * es el primero en salir.
 * en esta ocasion implemantado en base a nodos. 
 * @author (Ivan FC) 
 * @version (1. 01)
 */
public class Cola<T>
{
    protected NodoDE<T> frente, fin;
    public Cola(){
        frente = fin = null;
    }
    
    public boolean vacia(){
        return frente == null;
    }
    
    /**
     * El metodo encolar es sinonimo de insertar;
     * Por defecto inserta el dato por el final
     */
    public void encolar(T dato){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(vacia()){
            frente = fin = nuevo;
        }else{
            fin.setSig(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }
    
    /**
     * El metodo decolar es sinonimo de eliminar
     * Por defecto elimina el dato que vive al inicio d la cola
     */
    public T decolar(){
        T dato;
        if(vacia())
           dato = null;
        else{
            dato = frente.getDato();
            frente = frente.getSig();
            if(frente == null)
                fin = null;
            else
                frente.setAnt(null);
        }
        return dato;
    }
    
    /**
     * Devuelve el elementto del frente
     */
    public T ver(){
        T dato = null;
        if(!vacia())
            dato = frente.getDato();
        return dato;
    }
    
}
