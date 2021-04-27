package atguigu.linkedlist;

/**
 * @author zhu @create 2021-03-26 16:24
 */
public class DoubleLinkedList {
}



class HeroNode2{
    public int id;
    public String name;
    public String nickname;
    HeroNode2 pre ;
    HeroNode2 next;

    public HeroNode2(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}