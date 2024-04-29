package ed.edl;
/**
 * Esta lista se enlaza entre nuevas listas que apuntan al null
 * Almacena el dato y el siguiente sera otra Lista de la misma clase.
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ListaSE<T> implements Lista<T>
{
    private T          ini;
    private ListaSE<T> sig;
    public ListaSE(){
        ini = null;
        sig = null;
    }
    
    /**
     * permite saber el estado actual de la lista
     */
    public boolean vacia(){
        return ini == null;
    }
    
    /**
     * insertar el dato al final de la lista
     * @param dato a insertar de clase T
     * @retunr nada
     */
    public void insertar(T dato){
        if(vacia()){
            ini = dato;
            sig = new ListaSE();
        }else{
            sig.insertar(dato);
        }
    }
    
    public int longitud(){
        int tam;
        if(vacia()){
            tam = 0;
        }else{
            tam = 1 + sig.longitud();
        }
        return tam;
    }
    
    /**
     * accede al dato de la posicion pos si existiera
     * @param pos entero positivo incluido el 0
     * @return el dato accedido
     */
    public T acceder(int pos){
        T dato = null;
        if(pos >= 0 && pos < longitud()){
            if(!vacia()){
                if(pos == 0)
                    dato = ini;
                else
                    dato = sig.acceder(pos-1);
            }
        }
        return dato;
    }
    
    /**
     * acceder al dato de la coleccion
     * @param dato a ser accedido de clase T
     * @return dato accedido
     */
    public T acceder(T dato){
        T res;
        if(vacia())
            res = null;
        else{
            if(dato.equals(ini)){
                res = ini;
            }else{//Caso2: Si el dato esta en otra posicion
                res = sig.acceder(dato);
            }
        }
        return res;
    }
    
    /**
     * Inserta el dato dada una posicion
     */
    public void insertarDP(T dato, int pos){
        if(pos >= 0 && pos <= longitud()){
            if(pos == 0){
                ListaSE<T> aux = new ListaSE();//hacer una copia
                aux.insertar(ini);//insertar el primer dato en la copia
                aux.sig = sig;//guardar el resto de la lista en la copia
                ini = dato;//remplazar
                sig = aux;//reconectar los enlaces
            }else if(pos == longitud()){
                insertar(dato);
            }else{
                sig.insertarDP(dato, pos-1);
            }
        }
    }
    
    /**
     * elmina el dato de la posicion pos, en caso de existir y ademas devuelve el dato eliminado
     * @param pos es un entero positivo incluido el 0
     * @return el dato eliminado si existiera
     */
    public T eliminar(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            if(pos == 0){
                res = ini;
                ini = sig.ini;
                sig = sig.sig;
            }else{
                res = sig.eliminar(pos-1);
            }
        }
        return res;
    }
    
    public boolean buscar(T dato){
        boolean res;
        if(vacia())
           res = false;
        else{
            if(ini.equals(dato))
               res = true;
            else
               res = sig.buscar(dato);
        }   
        return res;
    }
    
    /**
     * Este metodo elimina el inicio de la lista
     */
    public void eliminarIni(){
        if(!vacia()){
            ini = sig.ini;
            sig = sig.sig;
        }        
    }
    
    public void reemplazar(T dato, int pos){
        if(pos >= 0 && pos < longitud()){
            if(!vacia()){
                if(pos == 0)
                    ini = dato;
                else
                    sig.reemplazar(dato, pos-1);
            }
        }
    } 
    
    public boolean compararDatos(int pos1, int pos2){
        boolean iguales = false;
        if(acceder(pos1).equals(acceder(pos2)))
            iguales = true;
        return iguales; 
    }
   
    public T eliminarDD(T dato){
        T res = null;
        if(vacia())
            res = null;
        else{
            if(ini.equals(dato)){
                res = dato;
                ini = sig.ini;
                sig = sig.sig;
            }else{
                dato = sig.eliminarDD(dato);
            }
        }
        return res; 
    }
    
    public void insertarTodos(Lista<T> otraLista){
        T almacen;
        for(int i = 0; i < otraLista.longitud(); i++){
            almacen = otraLista.acceder(i);
            insertar(almacen);
        }
    }
    
    public String toString(){
        String res = "";
        for(int i = 0; i < longitud(); i++){
            res += acceder(i).toString() + "\t";
        }
        return res;
    }
    
    public ListaSE<T> clon(){
        ListaSE<T> copia = new ListaSE();
        for(int i = 0; i < longitud(); i++){
            copia.insertar(acceder(i));
        }
        return copia;
    }
    
    public int indiceDe(T dato){
        int indice;
        if(vacia()){
            indice = -1;
        }else{
            if(dato.equals(ini)){
                indice = 0;
            }else{
                indice = sig.indiceDe(dato);
                if(indice != -1)
                    indice+=1;
            }
        }
        return indice;
    }
    
    public boolean sonIguales(ListaSE<T> otra){
        boolean loSon = false;
        if(!vacia() && !otra.vacia()){
            if(otra.longitud() == longitud()){
                for(int i = 0; i < otra.longitud() && loSon == true; i++){
                    if(otra.acceder(i) == acceder(i))
                        loSon = true;
                    else
                        loSon = false;
                }
            }
        }else
            loSon = false;
        return loSon;
    }
    
    public ListaSE<T> invertir(){
        ListaSE<T> invertido = new ListaSE();
        for(int i = longitud()-1; i > 0; i--){
            invertido.insertar(eliminar(i));
        }
        return invertido;
    }
}


