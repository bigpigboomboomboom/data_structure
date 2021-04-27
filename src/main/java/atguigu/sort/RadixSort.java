package atguigu.sort;

import java.util.Arrays;

/**
 * @author zhu @create 2021-04-15 16:36
 */
public class RadixSort {
    public static void main(String[] args) {
            int[] arr = {26,35,2,64,9,41,36,265,33,1,44654};
            radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static  void radixSort(int[] arr){

       //第一步，先求出数组中的最大值，用以确定位数比较次数
        int max = arr[0];
        for (int i = 0; i < arr.length ; i ++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        //十个桶，有可能所有同在一个桶中，所以桶的深度为数组长度
        int[][] bucket = new int[10][arr.length];

        //循环次数
        int num = (max +"").length();

        int[] bucketElementCount = new int[10];

        for(int i = 0,n =1 ; i < num ; i++ , n = n*10){

            for(int j = 0 ;j < arr.length; j++ ){
                int temp = arr[j] / n % 10 ;
                 bucket[temp][bucketElementCount[temp]] = arr[j];
                 bucketElementCount[temp]++ ;
            }
            int index = 0 ;
            for (int k = 0 ; k < bucket.length ; k++ ){
                if (bucketElementCount[k] != 0){
                    for(int l = 0 ; l < bucketElementCount[k] ; l++){
                        arr[index] = bucket[k][l];
                        index++;
                    }

                }
                bucketElementCount[k] = 0 ;


            }



        }
    }
}
