进程：系统分配处理器时间资源的基本单元。
线程：程序执行的最小单元。
A thread state. A thread can be in one of the following states:
NEW A thread that has not yet started is in this state.
RUNNABLE A thread executing in the Java virtual machine is in this state.
BLOCKED A thread that is blocked waiting for a monitor lock is in this state.
WAITING A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
TIMED_WAITING A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
TERMINATED A thread that has exited is in this state.
A thread can be in only one state at a given point in time. These states are virtual machine states which do not reflect any operating system thread states.

sleep / wait

串行 、并行 、 并发
并发：多个线程访问同一资源，多个线程对同一个点
    例子：春运抢票、电商秒杀
并行：多项工作一起执行，之后在汇总

管程（monitor监视器、锁）

用户线程、守护线程
用户线程：用户线程
守护线程：特殊线程，运行在后台，如垃圾回收
当主线程结束时，用户线程还在运行，则jvm存活；如果没有用户线程，都是守护线程，jvm结束。
