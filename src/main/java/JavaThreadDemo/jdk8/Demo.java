package JavaThreadDemo.jdk8;

import java.util.Arrays;

/**
 * @author lichenxu
 * @version V1.0
 * @Package JavaThreadDemo.jdk8
 * @date 2020/12/20 17:41
 * @example:
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
//        Arrays.stream(arr).forEach(System.out::println);
        Arrays.stream(arr).map(x->(x%2==0?x:x+1)).forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
