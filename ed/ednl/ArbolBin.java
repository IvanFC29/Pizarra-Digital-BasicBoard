package ed.ednl;
import ed.edl.*;

/**
 * Un ArbolBin es aquel que tiene restriccion en el grado,
 * tiene si izquierda y su derecha, de alli viene su nombre(Arbol Binario)
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ArbolBin<E> 
{
   private ArbolBin<E> izq;
   private E raiz;
   private ArbolBin<E> der;
   
   public ArbolBin(){
       raiz = null;
       izq = der = null;
   }
   
   public boolean vacio(){
       return raiz == null;//si no hay raiz, por ende no hay arbol
   }
   
   /*
    * /**
    * Se inserta un dato en la raiz siempre y cuando se encuentra un arbol vacio.
    * Caso1:Si el arbol der. esta vacio se inserta ahi
    * Caso2:Si el arbol der. esta lleno se inserta en el izq.
    * De ese modo sigue hasta llegar al final del arbol.
    * public boolean insertarProf(E dato){
       return insertarProf(dato, new ListaSE<E>());
   }//Aun no funciona
   private boolean insertarProf(E dato, ListaSE<E> ruta){
       boolean sePuede = true;
       E r1;
       if(vacio()){
           if(ruta.vacio()){
               raiz = dato;
               izq = new ArbolBin<E>();
               der = new ArbolBin<E>();
               sePuede = true;
           }
       }else{
           r1 = ruta.acceder(0);
           if(r1.equals(raiz)){
               ruta.eliminar(0);
               sePuede = izq.insertarProf(dato, ruta);
               if(!sePuede){
                   sePuede = der.insertarProf(dato, ruta);
                   ruta.insertarDP(r1,0);
               }
           }else if(r1 != raiz){
               sePuede = false;
           }
       }
       return sePuede;
   }
    */
   

 
   /**
    * Este metodo es insertar por Amplitud, se inserta los arboles en lista de espera
    * para ello se utiliza una Cola.
    * Caso1: Si esta vacio se inserta el dato.
    * Caso2: Si no esta vacio se enola el arbol(descendencia izq, der), y se repite la operacion
    */
   public void insertarAmp(E dato){
       Cola<ArbolBin<E>> cola;
       cola = new Cola<ArbolBin<E>>();
       cola.encolar(this);//arbol propio
       insertarAmp(dato, cola);
   }
   private void insertarAmp(E dato, Cola<ArbolBin<E>> cola){
       ArbolBin<E> candidato;
       candidato = cola.decolar();
       if(candidato.vacio()){
           candidato.raiz = dato;
           candidato.izq = new ArbolBin<E>();
           candidato.der = new ArbolBin<E>();
       }else{
           cola.encolar(candidato.izq);
           cola.encolar(candidato.der);
           insertarAmp(dato, cola);
       }
   }
   
   //Recorridos en Profundidad: Recorren el arbol y guardan los datos en una Lista
   /**
    * InOrden : izq, raiz, der
    * PreOrden : raiz, izq, der
    * PosOrden izq, der ,raiz
    */
   public ListaSE<E> inOrden(){
       ListaSE<E> lista = new ListaSE<E>();
       if(!vacio()){
           lista.insertarTodos(izq.inOrden()); 
           lista.insertar(raiz);
           lista.insertarTodos(der.inOrden());
       }
       return lista;
   }
   public ListaSE<E> preOrden(){
       ListaSE<E> lista = new ListaSE<E>();
       if(!vacio()){
           lista.insertar(raiz);
           lista.insertarTodos(izq.preOrden());
           lista.insertarTodos(der.preOrden());
       }
       return lista;
   }
   public ListaSE<E> posOrden(){
       ListaSE<E> lista = new ListaSE<E>();
       if(!vacio()){
           lista.insertarTodos(izq.posOrden());
           lista.insertarTodos(der.posOrden());
           lista.insertar(raiz);
       }
       return lista;
   }
   
   public E eliminar(E dato){
       E elDato;
       if(vacio()){
           elDato = null;
       }else{
           if(raiz.equals(dato)){
               if(raizHoja()){
                   elDato = raiz;
                   raiz = null;
                   izq = der = null;
               }else{
                   elDato =  null;
               }
           }else{
               elDato = izq.eliminar(dato);
               if(elDato == null){
                   elDato = der.eliminar(dato);
               }
           }
       }
       return elDato;
   }
   private boolean raizHoja(){
       return izq.vacio() && der.vacio();
   }
   
   public boolean eliminarDescendencia(E dato){
       boolean sePudo;
       if(vacio()){
           sePudo = false;
       }else{
           if(dato.equals(raiz)){
               sePudo = true;
               raiz = null;
               izq = null;
               der = null;
           }else{
               sePudo = izq.eliminarDescendencia(dato);
               if(sePudo == false){
                   sePudo = der.eliminarDescendencia(dato);
               }
           }
       }
       return sePudo;
   }
   
   public E acceso(E dato){
       E elDato;
       if(vacio()){
           elDato = null;
       }else{
           if(raiz.equals(dato)){
               elDato = raiz;
           }else{
               elDato = izq.acceso(dato);
               if(elDato == null){
                   elDato = der.acceso(dato);
               }
           }
       }
       return elDato;
   }
   
   /**
    * El nivel es una medida de profundidad
    */
   public int nivel(E dato){
       int elNivel;
       if(vacio())
           elNivel = -1;
       else{
           if(raiz.equals(dato)){
               elNivel = 0;
           }else{
               elNivel = izq.nivel(dato);
               if(elNivel == -1){
                   elNivel = der.nivel(dato);
               }
               if(elNivel != -1){
                   elNivel+=1;
               }
           }
       }
       return elNivel;
   }
   
   public int numeroHojas(){
       int numero;
       if(vacio())
           numero = 0;
       else{
           numero = izq.numeroHojas();
           if(izq.vacio()){
               numero+=1;
           }
           numero = der.numeroHojas();
           if(der.vacio()){
               numero+=1;
           }
       }    
       return numero;
   }
   
   public boolean esBalanceado(){
       boolean res = false;
       if(vacio())
          res = true;
       else{
           if(Math.abs(izq.altura()- der.altura()) <= 1){
               if(res){
                   res = izq.esBalanceado();
               }
               if(res){
                   res = der.esBalanceado();
               }
           }
       }   
       return res;
   }
   
   public int altura(){
       int alt;
       if(vacio()){
          alt = -1;
       }else{
          alt = 1 + Math.max(izq.altura(), der.altura()); 
       }
       return alt;
   }
   
   /**
    * Un arbol que cumple con el nombre sameFringe es aquel que
    * los nodos hoja del arbol actual(this) son inguales al otro arbol
    * de Izq a Der.
    */
   public boolean sameFringe(ArbolBin<E> otro){
       boolean res = false;
       Cola<E> c1 = this.getHojas();
       Cola<E> c2 = otro.getHojas();
       while(!c1.vacia() && !c2.vacia()){
           if(c1.decolar().equals(c2.decolar())){
               res = true;
           }else{
               res = false;
           }
       }
       if(c1.vacia() && !c2.vacia() || !c1.vacia() && c2.vacia())
           res = false;
       return res;
   }
   
   /**
    * El metodo devuelve las hojas de un arbol. de Izq a Der
    */
   public Cola<E> getHojas(){
       Cola<E> res = new Cola();
       if(!vacio()){
           getHojas(this, res);
       }
       return res;
   }
   private void getHojas(ArbolBin<E> act, Cola<E> res){
      if(!act.vacio()) 
        if(act.esHoja()){
            res.encolar(act.raiz);
        }else{
            getHojas(act.izq, res);
            getHojas(act.der, res);
        }
   }
   
   /**
    * Se dice que un elemento es Hoja si o solo si
    * su descendencia Izq y Der son null
    */
   public boolean esHoja(){
       boolean res = false;
       if(!vacio()){
         //if(izq.vacio() && der.vacio()){
           if(izq.raiz == null && der.raiz == null){
              res = true;
           }else{
              izq.esHoja();
              der.esHoja();
           }
         // }
       }
       return res;
   }
   
   /**
    * Se dice que es simetrico si 
    */
   public boolean esSimetrico(){
       boolean res;
       if(vacio()){
           res = true;
       }else{
           res = esSimetrico(izq, der);
       }
       return res;
   }
   private boolean esSimetrico(ArbolBin<E> ramaIzq, ArbolBin<E> ramaDer){
       boolean res;
       if(ramaIzq.vacio() && ramaDer.vacio()){
           res = true;
       }else if(ramaIzq.raiz.equals(ramaDer.raiz)){
           res = esSimetrico(ramaIzq.izq, ramaDer.der) && esSimetrico(ramaIzq.der, ramaDer.izq);;
       }else{
           res = false;
       }
       return res;
   }
   
   //Aun no funciona
   public boolean todosConDos(){
       boolean res = false;
       if(vacio()){
           res = false;
       }else{
           if(esHoja(raiz) == false){
               if(!izq.vacio() && !der.vacio())//si sus dos desencdencias no son vacios entonces tiene dos hojas
                   res = true;  
               else
                   res = false; 
                  
               if(izq.vacio() == false)
                    izq.todosConDos();
               if(der.vacio() == false)     
                    der.todosConDos();
           }
       }
       return res;
   }
   public boolean esHoja(E dato){
        boolean res;
        if(vacio())
            res = false;
        else{
            res = izq.esHoja(dato);
            if(izq.vacio()){
                res = true;
            }
            res = der.esHoja(dato);
            if(der.vacio()){
                res = true;
            }
        }
        return res;
    }
   
   public int nivel(){
       return altura()-1;
   }
   
   public ListaSE<E> accederNivel(int n){
        ListaSE<E> datos = new ListaSE<E>();
        accederNivel(n, datos);
        return datos;
   }
   private ListaSE<E> accederNivel(int n, ListaSE<E> datos){
        if(vacio()){
            datos = null;
        }else{
            if(n == 0){
                datos.insertar(raiz);
            }else{
                if(izq != null){
                    izq.accederNivel(n-1, datos);
                }
                if(der != null){
                    der.accederNivel(n-1, datos);
                }
            }
        }
        return datos;
   }
   
   public ListaSE<Dupla<E>> amplitudNivel(){
       ListaSE<Dupla<E>> res = new ListaSE();
       if(!vacio()){
           Cola<ArbolBin<E>> sec = new Cola();
           Cola<Integer> niv = new Cola();
           sec.encolar(this);
           niv.encolar(0);
           ArbolBin<E> aux;
           int n;
           while(!sec.vacia()){
               aux = sec.decolar();
               n = niv.decolar();
               res.insertar(new Dupla(aux.raiz, n));
               
               if(!aux.izq.vacio()){
                   sec.encolar(aux.izq);
                   niv.encolar(n+1);
               }
               if(!aux.der.vacio()){
                   sec.encolar(aux.der);
                   niv.encolar(n+1);
               }
           }
           System.out.println(res.toString());
       }
       return res;
   }
   
   /**Suponiendo que la altura empieza desde 1*/
   public void podar(int altura){
       podar(altura, this, 1);
   }
   private void podar(int altura, ArbolBin<E> act, int inicio){
       if(altura == inicio){
           act.izq = new ArbolBin();//null
           act.der = new ArbolBin();//null
       }else{
           if(!act.izq.vacio()){
               podar(altura, act.izq, inicio+1);
           }
           if(!der.der.vacio()){
               podar(altura, act.der, inicio+1);
           }
       }
   }
}
