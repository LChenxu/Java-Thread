package JavaThreadDemo.baseofjavathread;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseofjavathread
 * @date 2020/10/31 20:02
 * @example:
 * @Description:
 */
public class VolatileDemo {
    static volatile int i = 0;
    public static class MyThread implements Runnable{
        @Override
        public void run() {
            for (int j=0;j<10000;j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i=0;i<10;i++){
            ts[i] = new Thread(new MyThread());
            ts[i].start();
        }

        for (int i=0;i<10;i++){
            ts[i].join();
        }

        System.out.println(i);
    }
}
