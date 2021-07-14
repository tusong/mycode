package reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->test(),"线程A").start();
        new Thread(()->test(),"线程B").start();
    }

    public static void test(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取了锁");
        }catch (Exception e){

        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }
}
