package atguigu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author zhu @create 2021-04-11 21:13
 */
public class Test {
    static int a = 1 ;
    static int b = 2 ;

    @org.junit.jupiter.api.Test
    public void test(){


        int a = 5/2 ;
        int p ,q = 0;
        String b = "hello world  " ;
        int j = 4;
        j -= 3;
        System.out.println(j);
        System.out.println(b.length());
        int[] test={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(test);

        System.out.println(100/30);

        int i = mySqrt(2147395600);
        System.out.println(i);
        System.out.println(289389*289389);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


        public int mySqrt(int x) {
        if (x==0) return 0;
            if(x == 1) return 1;

            int l = 0 ;
            int r = x ;
            int ans = -1;
            int mid = 0  ;
            while (l <= r){
                mid = (r - l)/2 + 1 ;
                if ( mid * mid <= x ){
                    ans = mid ;
                     l = mid+1;
                }else {
                    r = mid - 1;
                }
            }
            return ans ;

        }

        @org.junit.jupiter.api.Test
         public  void test2(){
            int i = mySqrt(256);
            System.out.println(i);

            HashMap map = new HashMap();
            Set set = map.entrySet();
            for (Object entry : set){}

        }




}
