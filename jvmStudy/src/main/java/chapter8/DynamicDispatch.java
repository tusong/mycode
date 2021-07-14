package chapter8;

import java.util.HashMap;

/**
 *
 */
public class DynamicDispatch {

    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello(){
            System.out.println("hello man");
        }
    }

    static class WoMan extends Human {
        @Override
        protected void sayHello(){
            System.out.println("hello woman");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new WoMan();

        man.sayHello();
        woman.sayHello();

        man = new WoMan();
        man.sayHello();
    }
}
