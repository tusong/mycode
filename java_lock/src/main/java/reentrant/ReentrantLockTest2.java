package reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
    //公平锁的含义我们上面已经说了，就是谁等的时间最长，谁就先获取锁。
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(()->test(),"线程A").start();
        new Thread(()->test(),"线程B").start();
        new Thread(()->test(),"线程C").start();
        new Thread(()->test(),"线程D").start();
        new Thread(()->test(),"线程E").start();
        new Thread(()->test(),"线程F").start();
    }

    public static void test(){
        for (int i=0;i<2;i++){
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取了锁");
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }
}
