package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ColaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ColaTest
{
    @Test
    public void TestVacia(){
        Cola<Integer> c;
        c = new Cola<Integer>();
        assertEquals(true,    c.vacia());
    }
    @Test
    public void TestEncolar(){
        Cola<Integer> c;
        c = new Cola<Integer>();
        assertEquals(true,    c.vacia());
        c.encolar(0);
        c.encolar(1);
        assertEquals(false,  c.vacia());
    }
    @Test
    public void TestDecolar(){
        Cola<Integer> c;
        c = new Cola<Integer>();
        assertEquals(true,    c.vacia());
        c.encolar(0);
        c.encolar(1);
        assertEquals(false,  c.vacia());
        c.decolar();
        assertEquals(false,  c.vacia());
        c.decolar();
        assertEquals(true,   c.vacia());
    }
    @Test
    public void TestVer(){
        Cola<Integer> c;
        c = new Cola<Integer>();
        assertEquals(true,    c.vacia());
        c.encolar(0);
        c.encolar(1);
        assertEquals(false,  c.vacia());
        c.decolar();
        assertEquals(false,  c.vacia());
        c.decolar();
        assertEquals(true,   c.vacia());
        c.encolar(3);
        assertEquals(new Integer(3),   c.ver());
    }
}
