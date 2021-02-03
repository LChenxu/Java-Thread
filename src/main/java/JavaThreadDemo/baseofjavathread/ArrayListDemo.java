package JavaThreadDemo.baseofjavathread;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseofjavathread
 * @date 2020/11/1 11:27
 * @example:
 * @Description:
 */
public class ArrayListDemo {
    // 线程不安全
    public static ArrayList<Integer> list = new ArrayList<>(10);
    // 线程安全
    public static Vector<Integer> ve = new Vector<>(10);

    // 包一层
    public static List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>(10));

    public static class ThreadDemo implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10000;i++){
//                list.add(i);
//                ve.add(i);
                list1.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadDemo());
        Thread t2 = new Thread(new ThreadDemo());
        t1.start();t2.start();
        t1.join();t2.join();
//        System.out.println(list.size());
        System.out.println(list1.size());
    }
}
