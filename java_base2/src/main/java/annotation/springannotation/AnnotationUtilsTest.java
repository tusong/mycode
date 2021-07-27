package annotation.springannotation;

import annotation.ATable;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tusong
 * @version V1.0
 * @Package annotation.springannotation
 * @ClassName AnnotationUtilsTest.java
 * @date 2021/7/27
 * @Description:
 * get族方法
 * find族方法
 */

public class AnnotationUtilsTest {

    public static void main(String[] args) {
        test1();
    }



    static void test1(){

        ATable aTable = AnnotationUtils.findAnnotation(TestAn.class,ATable.class);
        Component component = AnnotationUtils.findAnnotation(TestAn.class, Component.class);
        System.out.println("find component:"+component);
        System.out.println("find aTable:"+component);

        ATable annotation = AnnotationUtils.getAnnotation(TestAn.class, ATable.class);
        Component annotation1 = AnnotationUtils.getAnnotation(TestAn.class, Component.class);
        System.out.println("get component:"+annotation1);
        System.out.println("get aTable:"+annotation);

        //获取注解的属性
        Map<String, Object> annotationAttributes = AnnotationUtils.getAnnotationAttributes(aTable);
        System.out.println("annotationAttributes"+annotationAttributes);
    }

    @ATable
    @Configuration
    static class TestAn {

    }

}


