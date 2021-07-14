package proxy.cglib;

import net.sf.cglib.core.KeyFactory;
import org.junit.Assert;
import org.junit.Test;
import proxy.SimpleKeyFactory;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy.cglib
 * @ClassName KeyFactoryTest.java
 * @date 2021/7/6
 * @Description: 此处添加类描述……
 */
public class KeyFactoryTest {

    @Test
    public void testKeyFactory() {
        SimpleKeyFactory simpleKeyFactory = (SimpleKeyFactory) KeyFactory.create(SimpleKeyFactory.class);

        Object o1 = simpleKeyFactory.newInstance("1",2);
        Object o2 = simpleKeyFactory.newInstance("1",2);

        Assert.assertEquals(o1,o2);
    }
}
