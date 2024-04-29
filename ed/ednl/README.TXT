public ListaSE<T> ramaMasLarga(){
ListaSE<T> ramaML ,rama;
ramaML = new ListaSE<>();
ListaSE<ListaSE<T>> ramas = todasLasRamas();
if(ramas.longitud()>0){
ramaML = ramas.acceder(0);
for(int i = 0;i<ramas.longitud();i++){
rama = ramas.acceder(i);
if(rama.longitud()>ramaML.longitud()){
ramaML = rama;
}
}
}
return ramaML;
}
public ListaSE<ListaSE<T>> todasLasRamas(){
ListaSE<ListaSE<T>> ramas = new ListaSE<ListaSE<T>>();
ListaSE<T> rama = new ListaSE<>();
buscarRamas(this,rama,ramas);
return ramas;
}
private void buscarRamas(ArbolBB<T> arbol,ListaSE<T> rama,ListaSE<ListaSE<T>> ramas){
if(!arbol.vacia()){
rama.insertar(arbol.raiz);
if(arbol.izq.vacia() && arbol.der.vacia()){
ramas.insertar(rama);
}
else{
if(!arbol.izq.vacia()){
buscarRamas(arbol.izq,rama.clonar(),ramas);
}
if(!arbol.der.vacia()){
buscarRamas(arbol.der,rama.clonar(),ramas);
}
}
}
}












public void insertarEn(T padre, T dato){
if(vacia()){
raiz = padre;
insertarEn(padre,dato);
}
else{
if(this.raiz.equals(padre)){
if(izq == null) izq = new ArbolBinario<T>(dato);
else if(der == null) der = new ArbolBinario<T>(dato);
}
else{
if(izq != null) izq.insertarEn(padre,dato);
if(der != null) der.insertarEn(padre,dato);
}
}
}


public void recolectarHojas(){
ListaSE<T> lista = new ListaSE<T>();
recolectarHojas(lista);
}
private void recolectarHojas(ListaSE<T> lista){
if(!vacia()){
if(izq.vacia() && der.vacia()){
lista.insertar(raiz);
}else{
izq.recolectarHojas(lista);
der.recolectarHojas(lista);
}
}
}