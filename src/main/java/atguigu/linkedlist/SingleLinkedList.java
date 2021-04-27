package atguigu.linkedlist;

/**
 * @author zhu @create 2021-03-24 10:44
 */
public class SingleLinkedList {
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void addNode(HeroNode heroNode){
        HeroNode temp = head;

        //while的目的是找到最后一个节点
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode ;
    }

    public void addNodeByNum(HeroNode heroNode){

        HeroNode temp = head;
        boolean flag = false ; //判断是否加入的Node的num是否已经存在

        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.num > heroNode.num){
                break;
            }else if (heroNode.num == temp.next.num){
                flag =true;
                break;
            }

            temp = temp.next;

        }

        if (flag){
            System.out.printf("准备插入的编号%d已经存在",heroNode.num);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void updateNode(HeroNode newHeroNode){

        if (head.next ==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;

        while (true){
            if (temp == null){
                break; //已经遍历完链表
            }
            if (temp.num == newHeroNode.num){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
           temp. name = newHeroNode.name;
           temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("未找到标号为%d的节点" + newHeroNode.num);
        }


    }


    //列出链表中所有元素
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        while(true){
            if (temp ==null){
                break;
            }
            System.out.println(temp);
            temp =temp.next;
        }

    }
}



class HeroNode{
    int num ;
    String name;
    String nickname;
    HeroNode next;

    public HeroNode(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
