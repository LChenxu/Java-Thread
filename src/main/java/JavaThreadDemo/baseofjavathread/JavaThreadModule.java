package JavaThreadDemo.baseofjavathread;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseOfJavaThread
 * @date 2020/10/31 11:27
 * @example:
 * @Description:
 */
public class JavaThreadModule {

    public enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED;
    }
}
