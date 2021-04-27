package atguigu;

/**
 * @author zhu @create 2021-04-10 10:05
 */
public class Singleton {
    private static  volatile Singleton instance = null;

    private Singleton(){}

    public  static    Singleton getInstance(){

        if (instance == null){
            synchronized(Singleton.class){
                if (instance ==null)
                    instance = new Singleton();
            }

        }
        return instance ;
    }
}
