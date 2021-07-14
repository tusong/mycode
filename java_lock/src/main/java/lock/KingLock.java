package lock;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class KingLock implements Lock {

    AtomicReference<Thread> owner = new AtomicReference<>();//默认值为null

    //吨列--存放哪些没有抢到锁的线程（线程安全+高效）
    LinkedBlockingDeque waiters = new LinkedBlockingDeque();
    @Override
    public void lock() {
        //cas
        while(!owner.compareAndSet(null,Thread.currentThread())){
            //false 抢不到怎么办？加入到阻塞队列
            waiters.add(Thread.currentThread());
            LockSupport.park();
            waiters.remove(Thread.currentThread());
        }
    }

    @Override
    public void unlock() {
        //只有持有锁的线程才能解锁
        if(owner.compareAndSet(Thread.currentThread(),null)){
            //唤醒其他等待的线程
            for(Object object:waiters.toArray()){
                Thread next = (Thread) object;
                LockSupport.unpark(next);
            }
        }else {
            //失败了不用作任何操作
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
