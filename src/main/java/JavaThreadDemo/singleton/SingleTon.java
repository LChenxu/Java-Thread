package JavaThreadDemo.singleton;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.singleton
 * @date 2020/12/12 10:18
 * @example:
 * @Description:
 */
public class SingleTon {
    // public static INT_NUM = 1;
    // 对于静态成员来说，使用一次就是初始化类中的所有静态成员，所以这种方式可能不可控制创建对象时机的
    private static SingleTon singleTon = new SingleTon();
    private SingleTon(){
        System.out.println("创建对象");
    }
    public static SingleTon getInstance(){
        return singleTon;
    }

}
