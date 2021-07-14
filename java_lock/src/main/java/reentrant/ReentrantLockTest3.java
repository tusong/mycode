package reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest3 {

    private static final ReentrantLock lock1 = new ReentrantLock(true);
    private static final ReentrantLock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock1,lock2),"线程A");
        Thread thread2 = new Thread(new ThreadDemo(lock1,lock2),"线程B");
        thread.start();
        thread2.start();

        thread.interrupt();
    }

    static class ThreadDemo implements Runnable{
        Lock firstLock;
        Lock secondLock;
        public ThreadDemo(Lock firstLock,Lock secondLock){
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }


        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();

                TimeUnit.SECONDS.sleep(1);

                secondLock.lockInterruptibly();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                firstLock.unlock();
                secondLock.unlock();
            }
        }
    }
}
