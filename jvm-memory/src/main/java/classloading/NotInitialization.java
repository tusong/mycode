package classloading;

/**
 * 非主动使用类字段演示
 * 通过子类引用父类的静态字段不会导致子类初始化
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
