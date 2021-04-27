package atguigu.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zhu @create 2021-04-13 17:09
 */
public class QuickSort {

    public static void quickSort(int[] nums , int left ,int right){
        int  l = left; //左下标
        int  r = right ; //由下标
        //中间值
        int temp = 0;
        int pivot = nums[ (right+left) / 2] ;
        while(l < r){
            while (nums[l] < pivot){
                l++;
            }

            while(nums[r] > pivot){
                r--;
            }

            if ( l == r ){
                break;
            }

            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp ;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(nums[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(nums[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(nums, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(nums, l, right);
        }
    }

    @Test
    public void test(){
        int[] nums = {9,11,10,5};
        int left = 0 ;
        int right = nums.length - 1 ;
        quickSort(nums,left,right);

        System.out.println(Arrays.toString(nums));
    }

}
