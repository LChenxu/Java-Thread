package JavaThreadDemo.reentrantlockdemo;

import javafx.animation.Timeline;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.reentrantlockdemo
 * @date 2020/11/1 18:12
 * @example:
 * @Description:
 */
public class TimeLock implements Runnable{
    static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
    }
}
