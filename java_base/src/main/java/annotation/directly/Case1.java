package annotation.directly;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author tusong
 * @version V1.0
 * @Package annotation.directly
 * @ClassName Case1.java
 * @date 2021/7/26
 * @Description:
 * E上没有A类型的注释，E是一个类，A的类型是可继承的，A存在于E的超类上。
 */
public class Case1 {

    public static void main(String[] args) {

        Annotation[] annotations = E.class.getAnnotations();
        for (int i = 0; i <annotations.length; i++) {
            System.out.println(annotations[i].toString());
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface A {}


class E extends SuperE{}

@A
class SuperE{}
