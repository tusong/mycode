package chapter05.java1;

/**
 * 演示栈中的异常 stackoverflow
 * 默认：count为10095
 * 设置-Xss256k count为2467
 */
public class StackErrorTest {

    static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }


}
