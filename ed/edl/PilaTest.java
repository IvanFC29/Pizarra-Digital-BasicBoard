package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PilaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PilaTest
{
    @Test
    public void TestEmpty(){
        Pila<Character> p;
        p = new Pila<Character>();
        assertEquals(true,   p.empty());
    }
    @Test
    public void TestPush(){
        Pila<Character> p;
        p = new Pila<Character>();
        assertEquals(true,   p.empty());
        p.push('a');
        p.push('b');      
        assertEquals(false,   p.empty());
    }
    @Test
    public void TestPop(){
        Pila<Character> p;
        p = new Pila<Character>();
        assertEquals(true,   p.empty());
        p.push('a');
        p.push('b');      
        assertEquals(false,   p.empty());
        p.pop();
        p.pop();
        assertEquals(true,    p.empty());
    }
    @Test
    public void TestTop(){
        Pila<Character> p;
        p = new Pila<Character>();
        assertEquals(true,   p.empty());
        p.push('a');
        p.push('b');      
        assertEquals(false,   p.empty());
        p.pop();
        p.pop();
        assertEquals(true,    p.empty());
        p.push('c');
        assertEquals(new Character('c'),    p.top());
    }
}
