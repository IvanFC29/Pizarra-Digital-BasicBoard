package ed.ednl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArbolBBTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArbolBBTest
{
   @Test
   public void Test_vacio(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
   }
   @Test
   public void Test_Insertar(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
       abb.insertar(6);             //   6
       abb.insertar(2);             //  / \
       abb.insertar(8);             // 2   8
       assertEquals(false,   abb.vacio());
   }
   @Test
   public void Test_Eliminar(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
       abb.insertar(6);             //   6
       abb.insertar(2);             //  /  \
       abb.insertar(8);             // 2    8
       abb.insertar(1);            // / \  / \
       abb.insertar(4);            //1   4
       assertEquals(false,   abb.vacio());
       abb.eliminar(6);
       assertEquals(new Integer(8),   abb.getRaiz());
   }
   @Test
   public void Test_Altura(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
       abb.insertar(6);             //   6
       abb.insertar(2);             //  /  \
       abb.insertar(8);             // 2    8
       abb.insertar(1);            // / \  / \
       abb.insertar(4);            //1   4
       assertEquals(false,   abb.vacio());
       assertEquals(2,   abb.altura());
   }
   @Test
   public void Test_Buscar(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
       abb.insertar(6);             //   6
       abb.insertar(2);             //  /  \
       abb.insertar(8);             // 2    8
       abb.insertar(1);            // / \  / \
       abb.insertar(4);            //1   4
       assertEquals(false,   abb.vacio());
       assertEquals(2,   abb.altura());
       assertEquals(new Integer(4),   abb.buscar(4));
   }
   @Test
   public void Test_esHoja(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
       abb.insertar(6);             //   6
       abb.insertar(2);             //  /  \
       abb.insertar(8);             // 2    8
       abb.insertar(1);            // / \  / \
       abb.insertar(4);            //1   4
       assertEquals(false,   abb.vacio());
       assertEquals(2,   abb.altura());
       assertEquals(true,   abb.esHoja(1));
   }
   @Test
   public void Test_Antecesor(){
       ArbolBB<Integer> abb;
       abb = new ArbolBB<Integer>();
       assertEquals(true,   abb.vacio());
       abb.insertar(6);             //   6
       abb.insertar(2);             //  /  \
       abb.insertar(8);             // 2    8
       abb.insertar(1);            // / \  / \
       abb.insertar(4);            //1   4
       assertEquals(false,   abb.vacio());
       assertEquals(2,   abb.altura());
       assertEquals(new Integer(1),   abb.antecesor(1));
   }
}
