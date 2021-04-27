package atguigu.sort;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhu @create 2021-04-02 16:11
 */
public class SelectSort {

    public void sort(int[] arr){
        int len = arr.length;

        for(int i = 0 ; i < len -1 ;i ++){
            int minIndex = i ;
            int min = arr[i];
           for (int j = i ; j < len -1 ;j ++ ){
               if (min > arr[j+1]){
                   min = arr[j+1];
                   minIndex = j+1;
               }
           }
           if (minIndex != i) {
               arr[minIndex] = arr[i];
               arr[i] = min;
           }
        }


    }


    @Test
    public void test(){
        int[] arr = new int[8];
        for (int i = 0 ; i < 8 ;i++){
            arr[i] = (int)(Math.random() * 80 );
        }
        System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String time1 = simpleDateFormat.format(date);
        System.out.println(time1);
        sort(arr);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
        System.out.println(Arrays.toString(arr));

    }
}
