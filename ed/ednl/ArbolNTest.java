package ed.ednl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArbolNTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArbolNTest
{
    @Test
    public void Test_Vacia(){
        ArbolN<Double> an;
        an = new ArbolN<Double>();
        assertEquals(true,  an.vacio());
    }
}
