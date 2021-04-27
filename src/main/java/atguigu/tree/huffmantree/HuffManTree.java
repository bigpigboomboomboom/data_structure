package atguigu.tree.huffmantree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author zhu @create 2021-04-21 16:56
 */
public class HuffManTree {
    public static void main(String[] args) {
        int[] arr = {1,3,7,5,6,23,15,2,9} ;
        Node tree = createHuffManTree(arr);
        tree.preOrder();

    }

    /**
     *
     * @param arr 传入的数组
     * @return 霍夫曼树的根节点
     */
    public static Node createHuffManTree(int[] arr) {
        ArrayList<Node> list = new ArrayList<>();
        for(int value : arr){
            list.add(new Node(value));
        }

        Collections.sort(list);
        System.out.println("排序后： "+list);

        while (list.size() > 1){

            Node leftNode = list.remove(0);
            Node rightNode = list.remove(0);

            Node p = new Node(leftNode.val + rightNode.val);
            p.left = leftNode;
            p.right = rightNode;
            list.add(p);
            Collections.sort(list);
        }

        return list.get(0);

    }

    public int[] levelOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Node> queen  = new LinkedList<>();

        if (root == null){
            return null;
        }else {
            queen.addLast(root);
            list.add(root.val);
        }

        while(queen.size() != 0){
            Node node = queen.removeFirst();
            if (node.left != null){
                queen.addLast(node.left);
                list.add(node.left.val);
            }

            if (node.right != null){
                queen.addLast(node.right);
                list.add(node.right.val);
            }
        }

        int[] res = new int[list.size()];

        for(int i = 0 ; i< list.size() -1 ; i++){
            res[i] = list.get(i);
        }
        return res ;
    }


    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer>  map = new HashMap<>();
        int len1 = list1.length;
        int len2 = list2.length;
        for (int i = 0 ; i< len2 ; i++){
                map.put(list2[i],i);
            }
       ArrayList<String> list = new ArrayList<>();
       int min = len1 +len2 -2 ;
        for (int i = 0 ; i< len1 ; i++){
            if (map.containsKey(list1[i])){
             int temp = i + map.get(list1[i]) ;
             if ( temp < min){
                 list.clear();
                 min = temp ;
                 list.add(list1[i]);

             }else if(min == temp){
                    list.add(list1[i]);
                }
            }
        }

        String[] res = new String[list.size()];
        for (int j = 0 ; j < list.size();j++){
            res[j]=list.get(j);
            boolean f =false;
        }



        return res;
    }
    }





class Node implements  Comparable<Node>{
    int val ;
    Node left ;
    Node right ;

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public int compareTo( Node o) {
        return this.val - o.val;
    }

    public void preOrder(){
        System.out.println(this);

        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }
    }


}