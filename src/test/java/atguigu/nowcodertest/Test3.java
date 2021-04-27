package atguigu.nowcodertest;

import java.util.Scanner;

/**
 * @author zhu @create 2021-04-15 21:14
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = 1024 -n;
        int count = 0;

        count = n/64 ;
        n =  n - 64*count;

        count =  count + n /16 ;
        n = n - 16*(n/16);

        count = count + n/4;
        n = n - 4*(n/4);

        System.out.println(n+count);


    }
}