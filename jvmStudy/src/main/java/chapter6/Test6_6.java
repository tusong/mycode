package chapter6;

public class Test6_6 {
    void onlyMe(Foo f){
        synchronized(f){
            doSomething();
        }}

        public void doSomething(){}
}

class Foo{

}
