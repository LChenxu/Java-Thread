package JavaThreadDemo.baseofjavathread;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseofjavathread
 * @date 2020/10/31 17:39
 * @example:
 * @Description:
 */
public class WaitAndNotify {
    final static  Object o = new Object();

    public static class WaitThread extends Thread{
        public WaitThread(String threadName){
            super(threadName);
        }
        @Override
        public void run() {
            synchronized (o){
                System.out.println(System.currentTimeMillis()+" : "+currentThread().getName()+" start!");
                try {
                    System.out.println(System.currentTimeMillis()+" : "+currentThread().getName()+" wait for object!");
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("wait时被中断同样会抛出InterruptedException");
                }
                System.out.println(System.currentTimeMillis()+" : "+currentThread().getName()+" end!");

            }
        }
    }

    public static class NotifyThread extends Thread{
        public NotifyThread(String threadName){
            super(threadName);
        }
        @Override
        public void run() {
            synchronized (o){
                System.out.println(System.currentTimeMillis()+" : "+currentThread().getName()+" notify!");
                o.notify();
                System.out.println(System.currentTimeMillis()+" : "+currentThread().getName()+" end!");
                try {
                    //验证唤醒的线程需要等待2s获取到锁之后才能真正的去执行
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new WaitThread("T1");
        Thread t2 = new NotifyThread("T2");
        t1.start();
        t2.start();
        //验证wait方法抛出异常
//        Thread.sleep(3000);
//        t1.interrupt();
    }
}
