package ed.edl;


/**
 * Esta es una lista que su ultimo nodo apunta al nodo del inicio
 * No se puede implementar en recursion directa
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ListaCSE<T> implements Lista<T>
{
    private NodoSE<T>  ini;
    public  ListaCSE(){
        ini = null;
    } 
    
    public boolean vacia(){
        return ini == null;
    }
    
    public void insertar(T dato){
        NodoSE<T> nuevo, ult;
        nuevo = new NodoSE(dato);
        if(vacia()){
            ini = nuevo;
            nuevo.setSig(nuevo);
        }else{
            ult = ini;
            while(ult.getSig() != ini){
                ult = ult.getSig();
            }
            ult.setSig(nuevo);
            nuevo.setSig(ini);
        }
    }
    
    public T acceder(int pos){
        T dato;
        NodoSE<T> ult;
        if(vacia() || pos < 0 || pos > longitud())
             dato = null;
        else{
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
         if(!vacia()){
             NodoSE<T> ult;
             ult = ini;
             do{
                 tam+=1;
                 ult = ult.getSig();
             }while(ult != ini);
         }
         return tam;
    }
    
    public void insertarDP(T dato, int pos){
       //No esta implementado
    }
    
    //Aun no funciona
    public T eliminar(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud() && !vacia()){
            if(longitud() == 1){
                res = ini.getDato();
                ini = null;
            }
            else if(pos % longitud() == 0){    
                NodoSE<T> ult = ini;
                while(ult != ini){
                    ult = ult.getSig();
                }
                res = ini.getDato();
                ini = ini.getSig();
                ult.setSig(ini);
                
            }else{
            
                }
        }    
        return res;
    }
    
    public boolean buscar(T dato){
        boolean res = false;
        if(!vacia()){
            NodoSE<T> ult;
            ult = ini;
            do{
                if(dato.equals(ult.getDato())){
                    res = true;
                }else{
                    ult = ult.getSig();
                }
            }while(ult!= ini && res != true);
        }
        return res;
    }
    
    
}
