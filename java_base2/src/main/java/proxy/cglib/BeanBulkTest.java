package proxy.cglib;

import net.sf.cglib.beans.BulkBean;
import org.junit.Test;
import proxy.SampleBean;

import static org.junit.Assert.assertEquals;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy.cglib
 * @ClassName BeanBulkTest.java
 * @date 2021/7/6
 * @Description: 相比于BeanCopier，BulkBean将copy的动作拆分为getPropertyValues和setPropertyValues两个方法，允许自定义处理属性
 * 扩展bean的属性
 * 使用注意：
 * 1. 避免每次进行BulkBean.create创建对象，一般将其声明为static的
 * 2. 应用场景：针对特定属性的get,set操作，一般适用通过xml配置注入和注出的属性，运行时才确定处理的Source,Target类，只需要关注属性名即可。
 */
public class BeanBulkTest {
    @Test
    public void testBulkBean() throws Exception{
        BulkBean bulkBean = BulkBean.create(SampleBean.class,
                new String[]{"getValue"},
                new String[]{"setValue"},
                new Class[]{String.class});
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        Object[] propertyValues = bulkBean.getPropertyValues(bean);
        assertEquals(1, bulkBean.getPropertyValues(bean).length);
        assertEquals("Hello world", bulkBean.getPropertyValues(bean)[0]);
        bulkBean.setPropertyValues(bean,new Object[]{"Hello cglib"});
        assertEquals("Hello cglib", bean.getValue());
    }
}
