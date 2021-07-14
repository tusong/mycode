package annotation;

import java.lang.annotation.Annotation;

/**
 * @author tusong
 * @version V1.0
 * @Package annotation
 * @ClassName InhertedTest.java
 * @date 2021/7/8
 * @Description: 此处添加类描述……
 */
public class InheritedTest {

    public static void main(String[] args) {

        Class<SubClass> subClassClass = SubClass.class;

        Annotation[] subClassClassAnnotations = subClassClass.getAnnotations();
        System.out.println("subClassClassAnnotations:"+subClassClassAnnotations.length);
        for (int i = 0; i < subClassClassAnnotations.length; i++) {
            Annotation annotation = subClassClassAnnotations[i];

            System.out.println("subClassClassAnnotations:"+annotation.toString());
        }
    }
}
