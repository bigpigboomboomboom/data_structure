package atguigu.sort;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhu @create 2021-04-02 15:27
 * 冒泡排序
 */
public class BubbleSort {

    public int[] bubbleSort(int[] arr){
        int len = arr.length ;
        int temp = 0 ;
        boolean flag = false ;

        for(int i = 0 ; i < len -1 ;i++){
            for (int j = 0 ; j < len -1 -i ;j ++){
                if (arr[j] > arr[j+1]){
                    flag =true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            //某一趟排序所有的数字都没有变化，则已经排序好了
            if (!flag){
                break;
            }else{
                flag = false ;
            }
        }
        return arr;
    }


    @Test
    public void test(){
        int[] arr = new int[80000];
        for (int i = 0 ; i < 80000 ;i++){
            arr[i] = (int)(Math.random() * 80000 );
        }
        //System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String time1 = simpleDateFormat.format(date);
        System.out.println(time1);
        bubbleSort(arr);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
        //System.out.println(Arrays.toString(arr));


    }
}
