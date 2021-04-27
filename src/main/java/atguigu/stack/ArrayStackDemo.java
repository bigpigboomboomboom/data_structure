package atguigu.stack;

/**
 * @author zhu @create 2021-03-30 19:40
 */
public class ArrayStackDemo {

}


class ArrayStack{
    private int maxSize ; //栈的大小
    private int[] stack;
    private int top = -1 ;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return  top == maxSize -1 ;
    }

    public  boolean isEmpty(){
        return  top == -1 ;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            return;
        }
        top++ ;
        stack[top] = value ;
    }


    public int pop(){
        if (isFull()){
            throw new RuntimeException("栈空");
        }

        int value = stack[top];
        top-- ;
        return value ;
    }

    public void list(){
        if (isFull()){
            System.out.println("栈空");
        }

        for (int i = top ; i >= 0 ;i--){
            System.out.printf("stack[%d] = %d\n",i ,stack[i]);
        }
    }
}