package atguigu.stack;

import org.junit.jupiter.api.Test;

/**
 * @author zhu @create 2021-03-30 21:59
 * 用单链表组成的栈
 */
public class LinkedListStack {
    /** Push element x to the back of queue. */

    StackNode head ;

    public void push(int x) {
        if (isEmpty()){
            head = new StackNode(x ,null);
        }else {
            head = new StackNode(x,head);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("栈空") ;
        }else{
             int res = head.value ;
            head = head.next ;
            return  res ;
        }
    }

    /** Get the front element. */
    public int peek() {
        if (isEmpty()){
            throw new RuntimeException("栈空") ;
        }else{
            return  head.value ;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean isEmpty(){
        return head == null ;
    }


    @Test
    public void test(){
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(3);
        linkedListStack.push(5);

        int pop = linkedListStack.pop();
        System.out.println(pop);

        int peek = linkedListStack.peek();
        System.out.println(peek);
    }

}


class StackNode{
    int value ;
    StackNode next ;
    public StackNode(int value, StackNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value=" + value +
                '}';
    }
}

