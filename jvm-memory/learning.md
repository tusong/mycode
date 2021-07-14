**自动内存管理机制**
程序计数器
java虚拟机栈
本地方法栈
java堆
方法区
运行时常量池
直接内存

java堆溢出
-Xms10m 设置最小堆
-Xmx10m 设置堆内存最大值
-XX:+HeapDumpOnOutOfMemoryError 设置报错时，dump内存快照
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

java虚拟机栈和本地方法栈
-Xss设置栈内存容量
如果线程请求的栈深度大于虚拟机所允许的最大深度，则抛出StackOverflowError
如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError。

运行时常量池溢出
-XX:PermSize
-XX:MaxPermSize 设置方法区永久代的最大值
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=1M; support was removed in 8.0


方法区溢出
方法区用于存放类的相关信息，类名，访问修饰符，常量池，字段描述，方法描述

本机直接内存溢出
-XX:MaxDirectMemorySize


**垃圾收集器与内存分配策略**
引用计数算法

根搜索算法

回收方法区
-Xnoclassgc

垃圾收集算法
标记清除算法
    优点
    缺点：1、效率不高 2、会产生大量不连续的内存碎片，空间碎片太多可能会导致，当程序要分配较大对象时无法找到足够的连续的内存空间而不得不提前触发垃圾收集。
复制算法
标记整理算法
分代收集算法

垃圾收集器
serial收集器


**对象分配与回收策略**
对象优先在eden分配
大对象直接进入老年代


虚拟机性能监控与故障处理工具
jps(JVM Process Status Tools) 虚拟机进程状况工具
jstat
jinfo
jmap
jhat
jstack

jconsole:java监视与管理控制台


5、调优案例分析与实战
