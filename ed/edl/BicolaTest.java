package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BicolaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BicolaTest
{
    @Test
    public void TestMeter(){
        Bicola<Integer> b;
        b = new Bicola<Integer>();
        b.encolar(1);
        assertEquals(new Integer(1),  b.ver());
        b.meter(0);
        assertEquals(new Integer(0),   b.ver());
    }
    @Test
    public void TestSalir(){
        Bicola<Integer> b;
        b = new Bicola<Integer>();
        b.encolar(1);
        assertEquals(new Integer(1),  b.ver());
        b.meter(0);
        assertEquals(new Integer(0),   b.ver());
        b.decolar();
        b.salir();
        assertEquals(true,    b.vacia());
    }
}
