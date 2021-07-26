package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author tusong
 * @version V1.0
 * @Package annotation
 * @ClassName AnnotationTest.java
 * @date 2021/7/8
 * @Description: 此处添加类描述……
 */
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchFieldException {




    }

    static Object getValueFromFieldAnnotation(Field filed){

        Annotation[] annotations = filed.getAnnotations();
//        Arrays.asList(annotations).stream().map((t)->t.an)
        return null;
    }

    static void test01() throws NoSuchFieldException {
        Class<User> userClass = User.class;

        Annotation[] userClassAnnotations = userClass.getAnnotations();

        System.out.println(userClassAnnotations.length);
        for (int i = 0; i < userClassAnnotations.length; i++) {
            System.out.println(userClassAnnotations[i].toString());
        }

        Field name = userClass.getDeclaredField("name");
        System.out.println("name.getAnnotatedType():"+name.getAnnotatedType());
        System.out.println(name.getAnnotation(MyAnnotation2.class));
        MyAnnotation2 myAnnotation2 = name.getAnnotation(MyAnnotation2.class);
        System.out.println("myAnnotation2.annotationType():"+myAnnotation2.annotationType());


        Class<User2> user2Class = User2.class;
        Annotation[] user2ClassAnnotations = user2Class.getAnnotations();
        System.out.println("user2ClassAnnotations:"+user2ClassAnnotations.length);
        for (int i = 0; i < user2ClassAnnotations.length; i++) {
            System.out.println("user2ClassAnnotations:"+user2ClassAnnotations[i].toString());
        }
    }



}
