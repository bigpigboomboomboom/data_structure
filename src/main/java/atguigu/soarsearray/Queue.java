package atguigu.soarsearray;

/**
 * @author zhu @create 2021-03-24 9:36
 * 用数组的方式实现队列
 */
public class Queue {

    private int maxSize;
    private int front ;
    private int rear;
    private int[] arr;

    public Queue(int maxSize){
        this.maxSize =maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部
        rear = -1;  //指向队列尾部
    }

    public boolean isFull(){
        return rear == maxSize - 1 ;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满了");
            return ;
        }

        rear++ ;
        arr[rear] = n;
    }

    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++; // front后移
        return arr[front];
    }

    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

}
