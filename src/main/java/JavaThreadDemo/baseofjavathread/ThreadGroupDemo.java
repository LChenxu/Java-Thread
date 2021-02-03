package JavaThreadDemo.baseofjavathread;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseofjavathread
 * @date 2020/11/1 10:34
 * @example:
 * @Description:
 */
public class ThreadGroupDemo implements Runnable{
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()+"-"+
                Thread.currentThread().getName();

        System.out.println("I am "+groupAndName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupDemo(), "t1");
        Thread t2 = new Thread(tg, new ThreadGroupDemo(), "t2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }
}
