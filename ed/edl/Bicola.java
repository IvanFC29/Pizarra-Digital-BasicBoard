package ed.edl;


/**
 * Write a description of class Bicola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicola<T> extends Cola<T>
{
    //atributos         |
    //encolar(dato)     |
    //decolar()          ===> heredados de la clase Cola<T>
    //vacia()           |
    //ver()             |
    public Bicola(){
        super();
    }
    
    /**
     * Permite meter un dat por el frente
     */
    public void meter(T dato){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(vacia()){
            frente = fin = nuevo;
        }else{
            nuevo.setSig(frente);
            frente.setAnt(nuevo);
            frente = nuevo;
        }
    }
    
    /**
     * Permite salir del final, sin haber llegado al frente
     */
    public T salir(){
        T dato;
        if(vacia())
           dato = null;
        else{
            dato = fin.getDato();
            fin = fin.getAnt();
            if(fin == null)
               frente = null;
            else
               fin.setSig(null);
        }   
        return dato;
    }
}
