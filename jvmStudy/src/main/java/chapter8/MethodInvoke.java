package chapter8;

/**
 invokestatic：调用静态方法。
 invokespecial：调用实例构造器＜init＞方法、私有方法和父类方法。
 invokevirtual：调用所有的虚方法。
 invokeinterface：调用接口方法，会在运行时再确定一个实现此接口的对象。
 invokedynamic：先在运行时动态解析出调用点限定符所引用的方法，然后再执行该方
 法，在此之前的4条调用指令，分派逻辑是固化在Java虚拟机内部的，而invokedynamic指令
 的分派逻辑是由用户所设定的引导方法决定的。
 */
public class MethodInvoke {
}
