package atguigu.sort;

import org.junit.jupiter.api.Test;

/**
 * @author zhu @create 2021-04-02 16:52
 * 插入排序
 */
public class InsertSort {
    public void sort(int[] arr){
        int len = arr.length;
        for (int i = 0 ; i < len ; i++){
            int insertValue = arr[i+1];
            int insertIndex = i ;

            while(insertValue < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex -- ;
            }



        }

            }
    @Test
    public void test(){

    }
}
