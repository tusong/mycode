package proxy.cglib;

import net.sf.cglib.beans.ImmutableBean;
import org.junit.Assert;
import org.junit.Test;
import proxy.SampleBean;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy.cglib
 * @ClassName ImmutableBeanTest.java
 * @date 2021/7/6
 * @Description: 此处添加类描述……
 */
public class ImmutableBeanTest {

    @Test(expected = IllegalStateException.class)
    public void testImmutableBean() throws Exception{
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean); //创建不可变类
        Assert.assertEquals("Hello world",immutableBean.getValue());
        bean.setValue("Hello world, again"); //可以通过底层对象来进行修改
        Assert.assertEquals("Hello world, again", immutableBean.getValue());
        immutableBean.setValue("Hello cglib"); //直接修改将throw exception
    }
}
