package chapter05.java1;

public class StackTest {
    public static void main(String[] args) {

        StackTest stackTest = new StackTest();
        stackTest.methodA();
    }

    public void methodA(){
        int i;
        int j;

        methodB();
    }

    public void methodB(){
        int k;
        int m;
    }
}
