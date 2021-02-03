package JavaThreadDemo.baseofjavathread;

import javax.sound.midi.Soundbank;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseofjavathread
 * @date 2020/10/31 16:45
 * @example:
 * @Description:
 */
public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){

            @Override
            public void run() {
//                int i =0;
                while (true){
//                    System.out.println(i++);
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("检测到中断标记，退出！");
                        break;
                    }
                    try {
                        System.out.println("start sleep");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("sleep时中断抛出中断异常，并复位中断标记!");
                        //中断标记复位，否则sleep清楚中断标价之后上面18行的代码就检测不到了
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };

        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
