package chapter8;

import java.io.Serializable;

/**
 * 静态分派
 * char-＞int-＞long-＞float-＞double
 */
public class Overload {

//    public static void sayHello(Object obj){
//        System.out.println("hello object");
//    }

//    public static void sayHello(Character arg){
//        System.out.println("hello Character");
//    }

//    public static void sayHello(char arg){
//        System.out.println("hello char");
//    }

//    public static void sayHello(int arg){
//        System.out.println("hello int");
//    }

//    public static void sayHello(Serializable arg){
//        System.out.println("hello Serializable");
//    }

    public static void sayHello(char... arg){
        System.out.println("hello char...");
    }


    public static void main(String[] args) {
        sayHello('a');
    }

}
