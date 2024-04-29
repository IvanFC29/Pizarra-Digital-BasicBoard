Que es una E.D.
 => Es una contenedora de tipo de datos, de forma dinamica
    El principio basico es:
        >hacer la E.D.
        >declararla
        >definir tipo de Dato
        >crearla
Clasificacion:
 => se clasifica por:
       >su organizacion ===> lineales, No lineales
       >su administracion ===> restrigidas, No restringidas
      
Lineles:
 => siguen una estructura en linea recta,
    >Listas; son No restringidas en operacion
    >Pila; son restringidas en operacion
           insercion y eliminacion controlada
           Son LIFO ==> Ultimo en entrar, Primero en salir
    >Cola; son restringidas en operacion
           insercion y eliminacion controlada
           Son FIFO ==> Primero en entar, Primero en salir
        =>Bicola; es una cola
                 T salir() ==> eliminar del final
                 void meter() ==> insertar del frente
        =>ColaPrioridad; es una cola
                         Inserta los datos de acuedo a un criterio de prioridad
                         
No Lineales:
 => Siguen una estructura conectada 
   Se toma la relacion arriba, abajo
   
   
   
   
   
   
Los arboles son ed conexas ===> true
  //Todo arbol esta conectado

Toda Lista sabe ordenar sus datos ===> false
  //La lista solo podria ordenar Integers

Una cola de Prioridad siempre inserta al inicio los datos ==> false
  //No siempre garantiza que vaya diercto al inicio
  
Cuando se elimina un elemento de un ArbolBin de busqueda siempre se recorre 
mas datos de los que tiene el arbol ==>  false
  //Al ser un ArbolBin de Busqueda puedo saber hacia donde ir
  
Las operaciones de insercion en una cola son rapidas ==> true
  //Porque solo insertaremos al final, obviamente conocemos el final
  
En un arbolBin de busqueda influye el orden de insercion para que la
busqueda sea rapida ===> false
  //En las lista si influye el orden mientras que en uno de busqueda ya esta ordenado
 
El recorrido por amplitud se aplica a edl ===> false
  //El recorrido en amplitud es de extremo a extremo(como una hoja)
  
Los arboles son adecuados para almacenar informacion en jerarquia ==> true
  //
  
La principal mision de un arbol binario de Busqueda es el ordenar ==> true
  //
  
Las colas respetan el modelo de administracion LIFO ==> false
  //first in, Last out

                 