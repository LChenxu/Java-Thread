package JavaThreadDemo;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo
 * @date 2020/11/2 16:01
 * @example:
 * @Description:
 */
public class Demo {

    public static class Task extends Thread{
        boolean stop = false;
        @Override
        public void run() {
            int i = 0;
            String s = "dasfdafsafasfasfasfsafasf";
            System.out.println(System.currentTimeMillis()+":begin");
            while (!stop) {
                i++;
                i = "llllllllllllllllllllll".length();
                i = "llllllllllllllllllllll".length();
                i = "llllllllllllllllllllll".length();
//                s = s+s+s+s;
            }
            System.out.println(System.currentTimeMillis()+":end;");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        task.start();
        Thread.sleep(300);
        task.stop = true;
    }
}
