package atguigu.tree.heapsort;

import java.util.Arrays;

/**
 * @author zhu @create 2021-04-21 10:21
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,3,8,5,6,8,10,12,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序!!");

//		//分步完成
//		adjustHeap(arr, 1, arr.length);
//		System.out.println("第一次" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//
//		adjustHeap(arr, 0, arr.length);
//		System.out.println("第2次" + Arrays.toString(arr)); // 9,6,8,5,4

        //完成我们最终代码
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeap(arr, i, arr.length);
        }
//
		/*
		 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　			3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for(int j = arr.length-1;j >0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        //System.out.println("数组=" + Arrays.toString(arr));

    }
    public static void  adjustHeap(int[] arr,int i ,int length){
        int temp = arr[i];

        for (int k = 2*i + 1 ; k < length ; k = 2*k +1){
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i=k;
            }   else {
                break;
            }

        }
        arr[i] = temp;

    }


}


class BinaryTree {
    private Node root ;

    public void setRoot(Node root){
        this.root = root ;
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public Node preOrderSearch(int id){
        if (root != null){
            return root.preOrderSearch(id);
        }else {
            return null;
        }
    }

    public Node infixOrderSearch(int id){
        if (root != null){
            return root.infixOrderSearch(id);
        }else {
            return null;
        }
    }

    public Node postOrderSearch(int id){
        if (root != null){
            return root.postOrderSearch(id);
        }else {
            return null;
        }
    }

    public void delNode(int id){
        if (root != null){

            if (root.getId() == id){
                root = null;
            }else {
                root.delNode(id);
            }

        }else {
            System.out.println("树为空~~~~");
        }
    }
}

//先创建节点
class Node{
    private int id ;
    private String name ;
    private Node left;
    private Node right;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        //先输出当前的节点
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right !=null){
            this.right.infixOrder();
        }

    }

    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }

        if (this.right !=null){
            this.right.postOrder();
        }
        System.out.println(this);

    }

    public Node preOrderSearch(int id){
        if(this.id  == id ){
            return this;
        }

        Node resNode = null;
        if (this.left !=null){
            resNode = this.left.preOrderSearch(id);
        }
        if (resNode !=null){
            return resNode ;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(id);
        }

        return resNode;
    }

    public Node infixOrderSearch(int id){

        Node resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(id);
        }
        if (resNode != null){
            return resNode ;
        }

        if (this.id == id){
            return this ;
        }

        if (this.right != null){
            resNode = this.right.infixOrderSearch(id);
        }
        return resNode ;
    }

    public Node postOrderSearch(int id){
        Node resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(id);
        }

        if (resNode !=null){
            return resNode;
        }

        if (this.right !=null){
            resNode = this.right.postOrderSearch(id);
        }
        if (this.id == id){
            return this;
        }
        return resNode;

    }

    public void delNode(int id){
        if (this.left != null && this.left.id == id){
            this.left = null ;
            return;
        }

        if (this.right != null && this.right.id == id){
            this.right = null ;
            return;
        }

        if (this.left != null){
            this.left.delNode(id);
        }
        if (this.right != null){
            this.right.delNode(id);
        }
    }


}