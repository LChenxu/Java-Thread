package JavaThreadDemo.threallocaldemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.threallocaldemo
 * @date 2020/11/15 15:58
 * @example:
 * @Description:
 */
public class ThreadLocal1 {

//    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class Task implements Runnable {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int i = 0;
        Task(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            try {
                Date date = sdf.parse("2020-11-15 16:01:"+i%60);
                System.out.println(i+":"+date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i<10; i++) {
            pool.submit(new Task(i));
        }
        pool.shutdown();
    }

}
