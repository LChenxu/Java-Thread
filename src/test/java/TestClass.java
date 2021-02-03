/**
 * @author lichenxu
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2021/1/1 16:51
 * @example:
 * @Description:
 */
public class TestClass {
    private int m;
    public static int inc(){
        int x;
        try {
            x = 1;
            return x;
        } finally {
            x=3;
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println(i);
        System.out.println(inc());
    }
}
