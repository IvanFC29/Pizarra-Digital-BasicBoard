package ed.edl;


/**
 * Esta Lista tiene dos enlaces
 * Al ser circular: el primero apunta a su siguiente y al ultimo
 * Su estructura es en base a nodos
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ListaCDE<T> implements Lista<T>
{
    private  NodoDE<T> ini;
    public ListaCDE(){
        ini = null;
    }
    
    public boolean vacia(){
        return ini == null;
    }
    
    public void insertar(T dato){
        NodoDE<T> nuevo, ult;
        nuevo = new NodoDE<T>(dato);
        if(vacia()){
            ini = nuevo;
            nuevo.setAnt(nuevo);
            nuevo.setSig(nuevo);
        }else{
            ult = ini;
            while(ult.getSig() != ini){
                ult = ult.getSig();
            }
            ult.setSig(nuevo);
            nuevo.setSig(ini);
            nuevo.setAnt(ult);    
        }
    }
    public T acceder(int pos){
         T dato;
         NodoDE<T> ult;
         if(vacia()){
             dato = null;
         }else{
             if(pos == 0){
                 dato = ini.getDato();
             }else{
                 ult = ini;
                 while(pos-- > 0){
                     ult = ult.getSig();
                 }
                 dato = ult.getDato();
             }
         }
         return dato;
    }
    public int longitud(){
        int tam = 0;
        NodoDE<T> ult;
        if(vacia())
            tam = 0;
        else{
            ult = ini;
            do{
                ult = ult.getSig();
                tam+=1;
            }while(ult != ini);
        }
        return tam;
    }
            
    public void insertarDP(T dato, int pos){
         NodoDE<T> nuevo = new NodoDE(dato);
         NodoDE<T> ant, ult, suc;
         if(vacia()){
            ini = nuevo;
            nuevo.setSig(nuevo);
            nuevo.setAnt(nuevo);
         }else{
             if(pos == 0){
                 ant = ini.getAnt();
                 nuevo.setSig(ini);
                 ini = nuevo;
                 nuevo.setAnt(ant);
             }else{
                 ult = ini;
                 while(pos-- > 0){
                     ult = ult.getSig();
                 }
                 suc = ult.getSig();
                 ant = ult.getAnt();
                 ant.setSig(nuevo);
                 nuevo.setSig(ult);
                 ult.setSig(suc);
                 nuevo.setAnt(ant);
             }
         }
    }
    
    public T eliminar(int pos){
        T dato;
        NodoDE<T> ant, ult, suc;
        if(vacia() || pos < 0 || pos > longitud()){
            dato = null;
        }else{
            ult = ini;
            do{
                ult = ult.getSig();
            }while(pos-- > 0);
            dato = ult.getDato();
            ant = ult.getAnt();
            suc = ult.getSig();
            ult.setSig(null);
            ult.setAnt(null);
            ant.setSig(suc);
            suc.setAnt(ant);
        }
        return dato;
    }
}
