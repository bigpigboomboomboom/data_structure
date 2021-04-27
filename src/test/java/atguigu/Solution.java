package atguigu;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhu @create 2021-04-08 18:57
 */

class Solution {


        /**
         *
         * @param numbers int整型一维数组
         * @param target int整型
         * @return int整型一维数组
         */
        public int[] twoSum (int[] numbers, int target) {
            // write code here
            HashMap<Integer,Integer> map = new HashMap<>();
            int[] res = new int[2];
            for(int i = 0 ; i < numbers.length ; i++){
                if (map.containsKey(numbers[i])){
                    res[0] =  map.get(numbers[i]) + 1;
                    res[1] = i + 1;
                    break;
                }else{
                    map.put(target - numbers[i],i);
                }
            }

         return res;
    }


        @Test
    public void test(){
//                   int[] input = {3,2,4};
//                   int k = 6;
//            int[] ints = twoSum(input, k);
//            System.out.println(Arrays.toString(ints));

        }

//广度优先遍历数的深度
    public int maxDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res =0 ;
       while (! queue.isEmpty()){
           int size = queue.size();

           while (size >  0){
               TreeNode node = queue.poll();
               if (node.left !=null){
                   queue.add(node.left);
               }

               if (node.right !=null){
                   queue.add(node.right);
               }
               size--;
           }
           res++;
       }
       return res;
    }

    //深度优先遍历数的深度
    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int leftDepth = maxDepth2(root.left);
            int rightDepth = maxDepth2(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();
        if (root != null){
            queue.add(root);
        }

        while( ! queue.isEmpty() ){
            int size = queue.size();
           List<Integer> temp = new ArrayList<>();
           boolean flag = false ;
            while(size> 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                size -- ;
            }
            res.add(temp);

        }
        return res;
    }

}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}




