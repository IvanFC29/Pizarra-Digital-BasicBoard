package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSETest
{
    @Test
    public void testVacia(){
        //devuelve true si esta vacia
        ListaSE<Integer> lse = new ListaSE();
        assertEquals(true,   lse.vacia());
    }
    @Test
    public void testVacia2(){
        //devuelve false si la lista tiene al menos un elemento
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(2); 
        assertEquals(false,   lse.vacia());
    }
    @Test
    public void testInsertar(){
        //inserta el nuevo elemento al final
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        assertEquals(false,   lse.vacia());
    }
    @Test
    public void testLongitud(){
        //devuelve la longitud de la lista
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(4);
        lse.insertar(2);
        assertEquals(2,   lse.longitud());
    }
    @Test
    public void testAcceder(){
        //accede al elemento dada una posicion
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(4);//pos 0
        lse.insertar(2);//pos 1
        assertEquals(new Integer(2), lse.acceder(1));
    }
    @Test
    public void testInsertarDP(){
        //inserta el dato dada una posicion
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(4);//pos 0 -->1
        lse.insertar(2);//pos 1 -->2
        lse.insertarDP(5,0);//pos 1 -->0
        assertEquals(new Integer(5), lse.acceder(0));
    }
    @Test
    public void testInsertDP2(){
        //inserta el dato dada una posicion
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(4);//pos 0 -->1 --->longitud 1
        lse.insertar(2);//pos 1 -->2 ---> longitud 2
        lse.insertarDP(5,2);//pos 1 -->0
        assertEquals(new Integer(5), lse.acceder(2));
    }
    @Test
    public void testInsertDP3(){
        //inserta el dato dada una posicion
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(1);//pos 0 -->0
        lse.insertar(2);//pos 1 -->2
        lse.insertar(3);//pos 2 --->3  
        lse.insertarDP(0,1); //pos -->1
       
        assertEquals(new Integer(2), lse.acceder(2));
        assertEquals(new Integer(1), lse.acceder(0));
        assertEquals(new Integer(3), lse.acceder(3));
        assertEquals(new Integer(0), lse.acceder(1));
    }
    @Test
    public void testEliminar(){
        //elimina el elemento dada una posicion
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);//pos 0 longitus 1
        lse.insertar(5);//pos 1  longitud 2
        lse.eliminar(1);//  longitud 1
        lse.eliminar(0);// longitud 0
        assertEquals(0,    lse.longitud());
        assertEquals(true,    lse.vacia());
    }
    @Test
    public void testAcceder_DD(){
        //acceder dado un dato si es que existe
        ListaSE<Character> lse;
        lse = new ListaSE<Character>();
        lse.insertar('x');//
        lse.insertar('y');//
        assertEquals(new Character('x'),    lse.acceder(new Character('x')));
        assertEquals(new Character('y'),    lse.acceder(new Character('y')));
    }
    @Test
    public void testBuscar(){
        //busca un dato si es que existe
        ListaSE<Character> lse;
        lse = new ListaSE<Character>();
        lse.insertar('x');//---> pos 0
        lse.insertar('y');//---> pos 1
        assertEquals(new Character('x'),    lse.acceder(new Character('x')));
        assertEquals(new Character('y'),    lse.acceder(new Character('y')));
        assertEquals(true,    lse.buscar(new Character('x')));
        assertEquals(false,    lse.buscar(new Character('h'))); 
    }
    @Test
    public void testEliminar_Inicio(){
        //Elimina el dato inicial
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        assertEquals(false,   lse.vacia());
        lse.eliminarIni();
        assertEquals(1,   lse.longitud());
        assertEquals(new Integer(5),    lse.acceder(0));
    }
    @Test
    public void testReemplazar(){
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        lse.insertar(7);
        lse.insertar(9);
        assertEquals(false,   lse.vacia());
        lse.reemplazar(8,2);
        assertEquals(new Integer(8),   lse.acceder(2));
    }
    @Test
    public void testComparar_Datos(){
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(3);
        lse.insertar(7);
        lse.insertar(9);
        assertEquals(false,   lse.vacia());
        lse.reemplazar(8,2);
        assertEquals(new Integer(8),   lse.acceder(2));
        assertEquals(true,   lse.compararDatos(0,1));
    }
    @Test
    public void testEliminar_Dato(){
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        lse.insertar(7);
        lse.insertar(9);
        assertEquals(false,   lse.vacia());
        lse.reemplazar(8,2);
        assertEquals(new Integer(8),   lse.acceder(2));
        lse.eliminarDD(new Integer(5));
        assertEquals(3,    lse.longitud());
    }
    public void TestIndiceDe(){
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        lse.insertar(7);
        lse.insertar(9);
        assertEquals(false,   lse.vacia());
        assertEquals(1,   lse.indiceDe(new Integer(5)));
    }
    public void TestSonIguales(){
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        lse.insertar(7);
        lse.insertar(9);
        ListaSE<Integer> lse2 = new ListaSE();
        lse2.insertar(3);
        lse2.insertar(5);
        lse2.insertar(7);
        lse2.insertar(9);
        assertEquals(true,    lse.sonIguales(lse2));
    }
    public void TestInvertir(){
        ListaSE<Integer> lse = new ListaSE();
        lse.insertar(3);
        lse.insertar(5);
        lse.insertar(7);
        
        ListaSE<Integer> inv = new ListaSE();
        inv = lse.invertir();
        assertEquals(new Integer(7),  inv.acceder(0));
        assertEquals(new Integer(5),  inv.acceder(1));
        assertEquals(new Integer(3),  inv.acceder(2));
        
    }
}
