package JavaThreadDemo.reentrantlockdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseofjavathread
 * @date 2020/11/1 11:59
 * @example:
 * @Description:
 */
public class ReentrantLockDemo implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    static int i = 0;

    @Override
    public void run() {
        for (int j =0;j<10000;j++){
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo r = new ReentrantLockDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
