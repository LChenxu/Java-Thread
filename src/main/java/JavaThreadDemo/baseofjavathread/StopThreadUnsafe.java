package JavaThreadDemo.baseofjavathread;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.baseOfJavaThread
 * @date 2020/10/31 15:26
 * @example:
 * @Description:
 */
public class StopThreadUnsafe {

    public static User u = new User();

    public static class User{
        private int id;
        private String name;

        public User() {
            id = 0;
            name =  "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    System.out.println("ReadObjectThread线程："+Thread.currentThread().getName());
                    if(u.getId() != Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }
    public static class ChangeObjectThread extends Thread{
        // 自己设置退出条件
        volatile boolean stopme = false;
        public void stopMe(){stopme = true;}
        @Override
        public void run() {

            while (true){
                // 当条件达成 退出
                if (stopme){
                    break;
                }
                synchronized (u){
                    int v = (int) (System.currentTimeMillis()/1000);
                    u.setId(v);
                    try {
                        System.out.println("ChangeObjectThread线程："+Thread.currentThread().getName());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true){
            Thread t = new ChangeObjectThread();
            t.start();
            System.out.println("Main线程："+Thread.currentThread().getName());
            Thread.sleep(150);
            t.stop();//废弃方法
        }
    }
}
