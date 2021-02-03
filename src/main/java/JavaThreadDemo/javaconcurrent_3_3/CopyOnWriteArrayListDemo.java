package JavaThreadDemo.javaconcurrent_3_3;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.javaconcurrent_3_3
 * @date 2020/11/14 19:51
 * @example:
 * @Description:
 */
public class CopyOnWriteArrayListDemo {

    public static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();


    public static class ReadThread implements Runnable {
        @Override
        public void run() {
            try {
                list.get(1);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class WriteThread implements Runnable {
        @Override
        public void run() {
            for (int i=0 ; i<10000 ; i++) {
                list.add(i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        list.add(1);
        list.add(2);
        list.add(3);

        ReadThread readThread =new ReadThread();
        WriteThread writeThread = new WriteThread();
        for (int i=0;i<20;i++) {
            new Thread(readThread).start();
        }
        Thread[] wl = new Thread[2];
        for (int i=0;i<2;i++) {
            wl[i] = new Thread(writeThread);
            wl[i].start();
        }

        for (int i=0;i<2;i++) {
            wl[i].join();
        }
        System.out.println(list.size());// 20000+3
    }
}
