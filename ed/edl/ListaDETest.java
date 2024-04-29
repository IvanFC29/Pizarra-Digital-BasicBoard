package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaDETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaDETest
{
    @Test
    public void TestVacia(){
        ListaDE<Double> lde;
        lde = new ListaDE<Double>();
        assertEquals(true,   lde.vacia());
    }
    @Test
    public void TestInsertar1(){
        ListaDE<Double> lde;
        lde = new ListaDE<Double>();
        assertEquals(true,   lde.vacia());
        lde.insertar(1.0);
        assertEquals(false,    lde.vacia());
    }
    @Test
    public void TestInsertar2(){
        ListaDE<Double> lde;
        lde = new ListaDE<Double>();
        assertEquals(true,   lde.vacia());
        lde.insertar(1.0);
        lde.insertar(2.0);
        lde.insertar(3.0);
        assertEquals(false,    lde.vacia());
    }
    /*
     * @Test
    public void TestInsertarDP(){
        ListaDE<Double> lde;
        lde = new ListaDE<Double>();
        assertEquals(true,   lde.vacia());
        lde.insertar(1.0);
        lde.insertar(2.0);
        lde.insertar(3.0);
        lde.insertarDP(2.5, 2);
        assertEquals(false,    lde.vacia());
        assertEquals(new Double(2.5),   lde.acceder(2));
    }
     */
    @Test
    public void TestLongitud(){
        ListaDE<Double> lde;
        lde = new ListaDE<Double>();
        assertEquals(true,   lde.vacia());
        lde.insertar(1.0);
        lde.insertar(2.0);
        lde.insertar(3.0);
        assertEquals(false,    lde.vacia());
        assertEquals(3,     lde.longitud());
    }
    @Test
    public void acceder_PosicionInvalida_Null(){
        ListaDE<Integer> lde = new ListaDE();
        lde.insertar(5);
        lde.insertar(6);
        lde.insertar(7);
        assertEquals(null, lde.acceder(10));
        assertEquals(null, lde.acceder(-1));
    }
    @Test
    public void acceder_PosicionValida_Elemento(){
        ListaDE<Integer> lde = new ListaDE();
        lde.insertar(5); //pos = 0
        lde.insertar(6); //pos = 1
        lde.insertar(7); //pos = 2
        assertEquals(new Integer(5), lde.acceder(0));
        assertEquals(new Integer(6), lde.acceder(1));
        assertEquals(new Integer(7), lde.acceder(2));
    }
    @Test
    public void TestEliminar(){
        ListaDE<Double> lde;
        lde = new ListaDE<Double>();
        assertEquals(true,   lde.vacia());
        lde.insertar(1.0);
        lde.insertar(2.0);
        lde.insertar(3.0);
        assertEquals(false,    lde.vacia());
        assertEquals(new Double(2.0),     lde.acceder(1));
        assertEquals(new Double(2.0),    lde.eliminar(1));
    }
    @Test
    public void Test_eliminar_PosicionInvalida_TamanioOriginal(){
        ListaDE<Integer> lde = new ListaDE();
        lde.insertar(5);
        lde.insertar(6);
        lde.insertar(7);
        assertEquals(null, lde.eliminar(10));
        assertEquals(null, lde.eliminar(-1));
        assertEquals(3, lde.longitud());
    }
    @Test
    public void Test_eliminar_PosicionInicial_TamanioOriginalMenos1(){
        ListaDE<Integer> lde = new ListaDE();
        lde.insertar(5); //pos = 0
        lde.insertar(6); //pos = 1   -> 0
        lde.insertar(7); //pos = 2   -> 1
        //longitud = 3
        assertEquals(new Integer(5), lde.eliminar(0));
        assertEquals(new Integer(6), lde.acceder(0));
        assertEquals(2, lde.longitud());
    }
    
    
}
