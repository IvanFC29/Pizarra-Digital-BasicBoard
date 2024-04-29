package ed.edl;


/**
 * Esta Lista tiene dos enlaces, una que apunta al sucesor y otra al antecesor
 * Su estructura esta en base a nodos
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ListaDE<T extends Comparable<T>> implements Lista<T>
{
    private NodoDE<T> ini;
    public ListaDE(){
        ini = null;
    }

    public boolean vacia(){
        return ini == null;
    }

    public void insertar(T dato){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(vacia()){
            ini = nuevo;
        }else{
            NodoDE<T> ult;
            ult = ini;
            while(ult.getSig() != null){
                ult = ult.getSig();
            }
            ult.setSig(nuevo);
            nuevo.setAnt(ult);
        }
    }
    
    public T acceder(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            res = acceder(pos, ini);
        }
        return res;
    }
    private T acceder(int pos, NodoDE<T> actual){
        T res;
        if(pos == 0)
            res = actual.getDato();
        else
            res = acceder(pos-1, actual.getSig());
        return res;
    }
    
    public int longitud(){
        int tam = 0;
        if(vacia())
            tam = 0;
         else{
            NodoDE<T> ult;
            ult = ini;
            do{
                ult = ult.getSig();
                tam+=1;
            }while(ult != null);
         }   
        return tam;
    }
    
    /*
     * Aun no funciona
     */
    public void insertarDP(T dato, int pos){
        NodoDE<T> nuevo, ant, ult;
        nuevo = new NodoDE<T>(dato);
        if(vacia()){
            ini = nuevo;
        }else{
            if(pos == 0){
                nuevo.setSig(ini);
                ini = nuevo;
            }else{
                ult = ini;
                while(pos > 0){
                    ult = ult.getSig();
                    pos-=1;
                }
                ant = ult.getAnt();
                ant.setSig(nuevo);
                nuevo.setSig(ult);
                nuevo.setAnt(ant);
                ult.setAnt(nuevo);
            }
        }
    }
    
    public T eliminar(int pos){
        T dato = null;
        if(vacia())
            dato = null;
        else if(pos >= 0 && pos < longitud()){
            if(pos == 0){
                dato = ini.getDato();
                ini = ini.getSig();
            }else{
                NodoDE<T> ult;
                ult = ini;
                do{
                    ult = ult.getSig();
                }while(pos-1 > 0);
                NodoDE<T> ant = ult.getAnt();
                NodoDE<T> suc = ult.getSig();
                ant.setSig(suc);
                if(suc != null)
                    suc.setAnt(ant);
                dato = ult.getDato();    
            }
        }   
        return dato;
    }
    
    
}
