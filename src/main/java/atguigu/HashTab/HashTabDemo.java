package atguigu.HashTab;

/**
 * @author zhu @create 2021-04-16 15:56
 */
public class HashTabDemo {

}


class HashTab{
    private int size;
    private EmpLinkedList[] empLinkedLists ;

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for(int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedLists[empLinkedListNO].add(emp);
    }

    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNO].findEmpById(id);
        if(emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public int hashFun(int id){
        return id % size ;
    }
}


class EmpLinkedList{
    private Emp head ;

    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }

        Emp curEmp = head ;
        while(curEmp.next != null){
            curEmp =curEmp.next;
        }
        curEmp.next = emp ;
    }

    public void list(int no){
        if (head == null){
            System.out.println("第"+(no+1)+"条链表为空");
            return;
        }

        System.out.println("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到，就返回Emp, 如果没有找到，就返回null
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if(head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while(true) {
            if(curEmp.id == id) {//找到
                break;//这时curEmp就指向要查找的雇员
            }
            //退出
            if(curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//以后
        }

        return curEmp;

    }






}

class Emp{
    int id  ;
    int name ;
    Emp next;

    public Emp(int id, int name) {
        this.id = id;
        this.name = name;
    }
}