package annotation.springannotation;

import function.entity.User;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.Conventions;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tusong
 * @version V1.0
 * @Package annotation.springannotation
 * @ClassName MetaTest.java
 * @date 2021/7/27 17:02
 * @Description: 此处添加类描述……
 */
@Configuration
public class MetaTest {

    @Bean
    public User user01(){
        return new User(1,"",1);
    }

    private static final Set<String> candidateIndicators = new HashSet<>(8);

    static {
        candidateIndicators.add(Component.class.getName());
        candidateIndicators.add(ComponentScan.class.getName());
        candidateIndicators.add(Import.class.getName());
        candidateIndicators.add(ImportResource.class.getName());
    }

    public static void main(String[] args) {
        test01();

        test02();

        test03();
    }


    static void test01(){

        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(MetaTest.class);
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        System.out.println(":"+metadata);

        candidateIndicators.forEach((t)->{
            System.out.println("metadata.isAnnotated("+ t + ")"+metadata.isAnnotated(t));
        });
        System.out.println("metadata.isAnnotated("+ Configuration.class.getName() + ")"+metadata.isAnnotated(Configuration.class.getName()));
    }


    static void test02(){
         final String CONFIGURATION_CLASS_ATTRIBUTE =
                Conventions.getQualifiedAttributeName(ConfigurationClassPostProcessor.class, "configurationClass");
        System.out.println("CONFIGURATION_CLASS_ATTRIBUTE:"+CONFIGURATION_CLASS_ATTRIBUTE);
    }

    static void test03(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("aaa",new AnnotatedGenericBeanDefinition(MetaTest.class));

        BeanDefinition beanDefinitionAAA = beanFactory.getBeanDefinition("aaa");
        System.out.println("beanDefinitionAAA:"+beanDefinitionAAA);
        //beanDefinitionAAA:Generic bean: class [annotation.springannotation.MetaTest]; scope=; abstract=false; lazyInit=null;
        // autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null;
        // initMethodName=null; destroyMethodName=null

        ConfigurationClassPostProcessor configurationClassPostProcessor = new ConfigurationClassPostProcessor();
        configurationClassPostProcessor.postProcessBeanDefinitionRegistry(beanFactory);
        User user01 = beanFactory.getBean("user01",User.class);
        System.out.println("user:"+user01);

    }

}
