package atguigu.tree;



import java.sql.SQLOutput;

/**
 * @author zhu @create 2021-04-16 20:40
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");
        Node node6 = new Node(6, "李逵");
        Node node7 = new Node(7, "燕青");
        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        node2.setLeft(node6);
        node2.setRight(node7);
        binaryTree.setRoot(root);

      // binaryTree.postOrder();
        System.out.println("**********");
        binaryTree.delNode(4);
       // binaryTree.postOrder();
//        Node node = binaryTree.postOrderSearch(4);
//        System.out.println(node);
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

    public  Node postOrderSearch(int id){
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