package atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhu @create 2021-04-16 10:02
 */
public class InsertValueSearch {
    public static void main(String[] args) {
//int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};


        //
//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println("resIndexList=" + resIndexList);
    }



    public static ArrayList<Integer> insertValueSearch(int[] arr ,int left ,int right ,int findValue){
        if (left > right || findValue > arr[arr.length-1] || findValue < arr[0]){
            return new ArrayList<>();
        }

        int mid = left + (findValue - arr[left]) / (arr[right] - arr[left]) *(right - left) ;
        int midValue = arr[mid];

        if (findValue < midValue){
                return insertValueSearch(arr,left,mid-1,findValue);
        }else if(findValue > midValue) {
            return insertValueSearch(arr,mid+1,right,findValue);
        }else {

            ArrayList<Integer> list = new ArrayList<Integer>();

            int temp1 = mid -1 ;
            while (true){
                if (temp1 < 0 || arr[temp1] !=findValue){
                    break;
                }
                list.add(temp1);
                temp1--;
            }
            list.add(mid);

            int temp2 = mid +1 ;
            while (true){
                if (temp2 > arr.length - 1 || arr[temp2] !=findValue){
                    break;
                }
                list.add(temp2);
                temp2++;
            }

            return list ;
        }


    }
}
