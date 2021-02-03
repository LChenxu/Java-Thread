package JavaThreadDemo.io;

import sun.security.provider.Sun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.io
 * @date 2020/12/20 9:42
 * @example:
 * @Description:
 */
public class MultiThreadEchoServer {
    private static ExecutorService pool = Executors.newCachedThreadPool();

    static class HandleMsg implements Runnable {
        Socket clientSocket;

        public HandleMsg(Socket socket) {
            clientSocket = socket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputline = null;
                long start = System.currentTimeMillis();
                while ((inputline = is.readLine()) != null) {
                    Thread.sleep(6000);
                    os.println(inputline);
                }
                long end = System.currentTimeMillis();
                System.out.println("spend:"+(end-start)+"ms");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                    if (os != null) os.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ServerSocket echoSocket = null;
        Socket clientSocket= null;
        try {
            echoSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                System.out.println(1);
                clientSocket = echoSocket.accept();
                System.out.println(clientSocket.getRemoteSocketAddress()+" connect!");
                pool.execute(new HandleMsg(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
