import com.AppConfig;
import com.circle.ClassA;
import com.e_1_6_1.LifeCycleAppConfig;
import com.e_1_6_1.LifecycleImpl;
import org.junit.Test;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

public class LifeCycleTest {


    @Test
    public void lifeCycleTest(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.getBean(ClassA.class);

        System.out.println(context.getBeansOfType(Lifecycle.class).toString());

    }

    @Test
    public void lifeCycleTest2(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        context.getBean(Lifecycle.class);



    }

    @Test
    public void lifeCycleTest3(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleAppConfig.class);

        context.getBean(LifecycleImpl.class);

        context.start();
        context.stop();
        context.close();

    }

}
