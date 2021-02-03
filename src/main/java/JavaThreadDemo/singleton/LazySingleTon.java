package JavaThreadDemo.singleton;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.singleton
 * @date 2020/12/12 10:25
 * @example:
 * @Description:
 */
public class LazySingleTon {
    //就算有其他静态成员也无所谓，因为给lazySingleTon对象初始化的是null
    private static LazySingleTon lazySingleTon = null;
    private LazySingleTon(){
        System.out.println("创建对象");
    }
    //多判断一步null可能带来并发问题，创建多个对象所以要加锁
    public static synchronized LazySingleTon getInstance(){
        if (lazySingleTon == null){
            lazySingleTon = new LazySingleTon();
        }
        return lazySingleTon;
    }

}
