package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaCDETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaCDETest
{
    @Test
    public void TestVacia(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
    }
    @Test
    public void TestInsertar(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);
        assertEquals(false,   lcde.vacia());
    }
    @Test
    public void TestInsertar2(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);
        lcde.insertar(3);
        lcde.insertar(6);
        assertEquals(false,   lcde.vacia());
    }
    @Test
    public void TestLongitud(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);
        lcde.insertar(3);
        lcde.insertar(6);
        assertEquals(false,   lcde.vacia());
        assertEquals(3,   lcde.longitud());
    }
    @Test
    public void TestEliminar_Dada_Pos(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);
        lcde.insertar(3);
        lcde.insertar(6);
        assertEquals(false,   lcde.vacia());
        assertEquals(3,   lcde.longitud());
        lcde.eliminar(1);
        assertEquals(2,   lcde.longitud());
    }
    @Test
    public void TestAcceder(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);//--->0
        lcde.insertar(3);///---->1
        lcde.insertar(6);//---->2
        assertEquals(false,   lcde.vacia());
        assertEquals(3,   lcde.longitud());
        assertEquals(new Integer(6),     lcde.acceder(2));
    }
    @Test
    public void TestInsertar_Dada_Pos(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);//--->0
        lcde.insertar(3);///---->1
        lcde.insertar(6);//---->2
        assertEquals(false,   lcde.vacia());
        assertEquals(3,   lcde.longitud());
        lcde.insertarDP(new Integer(1), 1);
        assertEquals(new Integer(1),     lcde.acceder(1));
        assertEquals(4,   lcde.longitud());
        assertEquals(new Integer(3),   lcde.acceder(2));
    }
    @Test
    public void TestInsertar_Dada_Pos2(){
        ListaCDE<Integer> lcde;
        lcde = new ListaCDE();
        assertEquals(true,   lcde.vacia());
        lcde.insertar(2);//--->0
        lcde.insertar(3);///---->1
        lcde.insertar(6);//---->2
        assertEquals(false,   lcde.vacia());
        assertEquals(3,   lcde.longitud());
        lcde.insertarDP(new Integer(1), 0);
        assertEquals(new Integer(1),     lcde.acceder(0));
        assertEquals(new Integer(2),     lcde.acceder(1));
        assertEquals(new Integer(3),     lcde.acceder(2));
        assertEquals(new Integer(6),     lcde.acceder(3));
        //assertEquals(4,   lcde.longitud());
    }
}
