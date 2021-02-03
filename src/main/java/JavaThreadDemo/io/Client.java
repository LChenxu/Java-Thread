package JavaThreadDemo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.io
 * @date 2020/12/20 9:53
 * @example:
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            client = new Socket();
            client.connect(new InetSocketAddress("localhost", 8000));
            writer = new PrintWriter(client.getOutputStream(), true);
            Thread.sleep(10);

            writer.println("Hello!");
            writer.flush();

            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("from server: " + reader.readLine());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (client != null) {
                client.close();
            }
        }
    }
}
