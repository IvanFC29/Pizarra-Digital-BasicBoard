public interface Lista<T>{
    /**
     * permite saber el estado actual de la lista
     */
    public boolean vacia();
    
    /**
     * insertar el dato al finald e la lista
     * @param dato a insertar de clase T
     * @retunr nada
     */
    public void insertar(T dato);
    
    /**
     * elmina el dato de la posicion pos, en caso de existir y ademas devuelve el dato eliminado
     * @param pos es un entero positivo incluido el 0
     * @return el dato eliminado si existiera
     */
    public T eliminar(int pos);

    /**
     * elimina el dato de la lista
     * @param dato a eliminar de clase T
     * @return el dato eliminado si existiera
     */
    public T eliminar(T dato);
    
    /**
     * accede al dato de la posicion pos si existiera
     * @param pos entero positivo incluido el 0
     * @return el dato accedido
     */
    public T acceder(int pos);
    
    /**
     * acceder al dato de la coleccion
     * @param dato a ser accedido de clase T
     * @return dato accedido
     */
    public T acceder(T dato);
    
    /**
     * inserta dato en la posicion pos
     * @param dato de clase T a insertar
     * @param pos en la que se quiere insertar pos>=0 entero
     * @return nada
     */
    public void insertar(T dato, int pos);
    
    public boolean buscar(T dato);
    
    public int indiceDe(T dato);
    
    public int longitud();
    
    public boolean intercambiar(int pos1, int pos2);
    
    public void reemplazar(T dato, int pos);
    
    public boolean compararDatos(int pos1, int pos2);
    
    public boolean equals(Lista<T> otraLista);
    
    public Lista<T> clonar();
    
    public void vaciar();
    
    public String toString();
    
    public void invertir();
    
    public void insertarTodos(Lista<T> otraLista);

}


