package atguigu.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author zhu @create 2021-03-24 14:20
 */
public class SingleLinkedListTest {

    @Test
    public void  test(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node3 = new HeroNode(3,"智多星","吴用");
        HeroNode node2 = new HeroNode(2,"玉麒麟","卢俊义");

        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node3);
        singleLinkedList.addNode(node2);

        singleLinkedList.list();
    }

    @Test
    public void  test1(){
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(2,"玉麒麟","卢俊义");
        HeroNode node3 = new HeroNode(3,"智多星","吴用");
        HeroNode node8 = new HeroNode(8,"黑旋风","李逵");


        singleLinkedList1.addNodeByNum(node1);
        singleLinkedList1.addNodeByNum(node2);
        singleLinkedList1.addNodeByNum(node8);
        singleLinkedList1.addNodeByNum(node3);
        singleLinkedList1.addNodeByNum(node2);

        singleLinkedList1.list();
        System.out.println("*********");
        HeroNode newNode3 = new HeroNode(3,"小智","吴用~~");
        singleLinkedList1.updateNode(newNode3);
        singleLinkedList1.list();

    }

}
