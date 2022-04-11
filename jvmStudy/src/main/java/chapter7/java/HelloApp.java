package chapter7.java;

public class HelloApp {

    static int i ;//prepare:0
    static char c ;//prepare:
    static long l;//0
    static float f;//0.0
    static double d;//0.0
    static boolean b;//false
    static byte aByte;//0
    static short aShort;//0
    static int a = 1;//prepare:0 ----> initial : 1

    public static void main(String[] args) {
        System.out.println("i:"+i);
        System.out.println("c:"+c);
        System.out.println("l:"+l);
        System.out.println("f:"+f);
        System.out.println("d:"+d);
        System.out.println("aByte:"+aByte);
        System.out.println("aShort:"+aShort);
        System.out.println("b:"+b);
        System.out.println("a:"+a);
    }

}
