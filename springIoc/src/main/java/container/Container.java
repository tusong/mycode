package container;

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class Container {

//    public static void main(String[] args) {
//
//        //创建和配置beans
//        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
//        //获取bean实例
//        context.getBean("");
//
//        //groovy配置
//        context = new GenericGroovyApplicationContext("services.groovy", "daos.groovy");
//
//        //使用GenericApplicationContext，XmlBeanDefinitonReader 读取xml配置
//        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
//        new XmlBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("","");
//        genericApplicationContext.refresh();
//
//        //也可以使用GroovyBeanDefinitionReader读取groovy配置
//        new GroovyBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("services.groovy", "daos.groovy");
//        genericApplicationContext.refresh();
//    }
}
