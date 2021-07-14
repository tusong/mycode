package annotaion.use;

import annotaion.Annotation1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Use1 {

    public static void main(String[] args) {
        Class class1 = Use1.class;
        //Retention为
        Annotation[] annotations = class1.getAnnotations();
        System.out.println(annotations.length);
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].toString());
        }

        Class class2 = AnnotationMethod.class;
        Method[] methods = class2.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Annotation[] annotations2 = methods[i].getDeclaredAnnotations();
            for (int j = 0; j < annotations2.length; j++) {
                Annotation annotationj = annotations2[j];
                System.out.println(annotations2[j].toString());
            }
        }

    }
}
