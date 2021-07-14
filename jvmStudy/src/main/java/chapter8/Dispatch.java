package chapter8;

/**
 *
 */
public class Dispatch {
    static class _360{};
    static class QQ{};

    static class Father{
        void hardChoice(_360 arg){
            System.out.println("father _360");
        }
        void hardChoice(QQ qq){
            System.out.println("father QQ");
        }
    }
    static class Son extends Father{
        @Override
        void hardChoice(_360 arg){
            System.out.println("son _360");
        }
        @Override
        void hardChoice(QQ qq){
            System.out.println("son QQ");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
