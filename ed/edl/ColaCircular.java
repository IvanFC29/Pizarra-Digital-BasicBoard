package ed.edl;


/**
 * Una cola circular es aquella en la que hay un limite de elementos,
 * este se define en la longitud de la cola.
 * Como toda Cola, la unica difrenci es que al insertar se verifica que Cola
 * no este llena.
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ColaCircular<T> extends Cola<T>
{
   //frente i fin ==> heredadoos
   private int capacidad;
   public ColaCircular(int capacidad){
       super();
       this.capacidad = capacidad;
   }
   
   //vacia() --|
   //ver()      ==> heredado
   //decolar()_| 
   
   public String encolarCC(T dato){
       String reporte = "La cola aun tiene espacio";
       if(llena()){
           reporte = "La cola esta completa";
       }else{
           NodoDE<T> nuevo = new NodoDE<T>(dato);
           if(vacia()){
               frente = fin = nuevo;
           }else{
               fin.setSig(nuevo);
               nuevo.setAnt(fin);
               fin = nuevo;
           }
       }
       return reporte;
   }
   
   public boolean llena(){
       if(fin == null)
          return false;
       else
          return true;
   }
   
   public int getCapacidad(){
       return this.capacidad;
   }
}
