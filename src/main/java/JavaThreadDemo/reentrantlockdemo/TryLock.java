package JavaThreadDemo.reentrantlockdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.reentrantlockdemo
 * @date 2020/11/1 18:17
 * @example:
 * @Description:
 */
public class TryLock implements Runnable{
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();
    int lock;
    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()){
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {}

                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId()+":My job done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {}

                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId()+":My job done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock tryLock1 = new TryLock(1);
        TryLock tryLock2 = new TryLock(2);
        Thread t1 = new Thread(tryLock1);
        Thread t2 = new Thread(tryLock2);
        t1.start();t2.start();
    }
}
