package atguigu;

/**
 * @author zhu @create 2021-04-13 20:07
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Class_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in) ;
        while(reader.hasNext())
        {
            int m = reader.nextInt() ;
            int [] numbers = new int[m] ;
            for(int index=0;index<m;index++)
            {
                numbers[index] = reader.nextInt();
            }
            ArrayList<Object> objects = new ArrayList<>();
           // objects.subList();
            Arrays.asList();
            System.out.println(Arrays.toString(numbers));
        }

        reader.close() ;
    }
}
