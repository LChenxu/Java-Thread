package JavaThreadDemo.singleton;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.singleton
 * @date 2020/12/12 10:29
 * @example:
 * @Description:
 */
public class StaticSingleTon {
    private StaticSingleTon(){
        System.out.println("创建对象");
    }
    private static class SingletonHolder{
        private static StaticSingleTon instance = new StaticSingleTon();
    }

    public static StaticSingleTon getInstance(){
        return SingletonHolder.instance;
    }
}
