package atguigu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test(){
        HashSet set = new HashSet();
//        set.add(new Integer(4));
//        set.add(new Integer(4));
     //   set.add(4);
        boolean add = set.add(4);
        int size = set.size();
        System.out.println(size);
        System.out.println(add);


        for (Object integer : set ){
            System.out.println(integer);
        }

    }
}


