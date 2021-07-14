package proxy.cglib;

import net.sf.cglib.beans.BeanCopier;
import org.junit.Test;
import proxy.OtherSampleBean;
import proxy.SampleBean;

import static org.junit.Assert.assertEquals;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy.cglib
 * @ClassName BeanCopierTest.java
 * @date 2021/7/6
 * @Description: 此处添加类描述……
 */
public class BeanCopierTest {
    @Test
    public void testBeanCopier() throws Exception{
        BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);//设置为true，则使用converter
        SampleBean myBean = new SampleBean();
        myBean.setValue("Hello cglib");
        OtherSampleBean otherBean = new OtherSampleBean();
        copier.copy(myBean, otherBean, null); //设置为true，则传入converter指明怎么进行转换
        assertEquals("Hello cglib", otherBean.getValue());
    }
}
