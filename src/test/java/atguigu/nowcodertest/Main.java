package atguigu.nowcodertest;

/**
 * @author zhu @create 2021-04-15 19:33
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] attack = new int[n];
        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            attack[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            money[i] = sc.nextInt();
        }

//        TreeMap<Integer,Integer> map =new TreeMap<>();
////        for(int i = 0; i < n; i++){
////            map.put(attack[i],money[i]);
////        }
////        Collection<Integer> values = map.values();
////        for(int j : values){
////
////        }

        boolean flag = false;
        int temp =0;
        for(int i = 0 ; i < n -1 ;i++){
            for (int j = 0 ; j < n -1 -i ;j ++){
                if (attack[j] > attack[j+1]){
                    flag =true;
                    temp = attack[j];
                    attack[j] = attack[j+1];
                    attack[j+1] = temp;

                    temp = money[j];
                    money[j] = money[j+1];
                    money[j+1] = temp;
                }
            }
            //某一趟排序所有的数字都没有变化，则已经排序好了
            if (!flag){
                break;
            }else{
                flag = false ;
            }
        }


        int[] res = new int[n];
// 1 5 8 6 5 k =2
        for (int i = 0 ; i<n ; i++){

            if (i <= k){
                for (int j = 0; j <= i ;j++){
                    res[i] =res[i]+money[j];

                }
            }

            else {
                for (int j = i-k; j <= i ;j++){
                    res[i] =res[i]+money[j];
                }
            }

        }


    }
}
