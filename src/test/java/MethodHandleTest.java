import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author lichenxu
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2021/1/3 18:17
 * @example:
 * @Description:
 */
public class MethodHandleTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decode = "UTF-8";
        String s = "一爨";
        System.out.println(s.length());
        byte[] bytes = s.getBytes(decode);
        System.out.println(new String(bytes,decode));
        System.out.println(bytes.length);
        String s1 = new String(bytes, 0, 4, decode);
        byte[] bytes1 = s1.getBytes(decode);
        String s2 = new String(bytes, 4, 2, decode);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 + s2);

//        byte[] bytes1 = s1.getBytes(decode);
        byte[] bytes2 = s2.getBytes(decode);
        byte[] nb = new byte[bytes.length];
        System.arraycopy(bytes1, 0, nb, 0, bytes1.length);
        System.arraycopy(bytes2, 0, nb, bytes1.length - 1, bytes2.length);
        System.out.println(new String(nb, decode));
    }
}
