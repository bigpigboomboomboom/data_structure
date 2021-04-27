package atguigu;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhu @create 2021-04-12 10:21
 */
public class test2 {
    public ListNode linktest(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr ;
            curr = next ;
        }

        return prev ;

    }

    public int contextfind(int k , int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            if (hashMap.containsKey(n)) {
                hashMap.put(n, hashMap.get(n) + 1);
            } else {
                hashMap.put(n, 1);
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        return entries.get(k-1).getKey();
    }



    @Test
    public void  test(){
        int k = 1 ;
        int[] nums = {2,3,3,4,5,5,5,5,6,6,6};
        int contextfind = contextfind(k, nums);
        System.out.println(contextfind);
    }




}
 class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x ;
    }

     public ListNode() {
     }
 }