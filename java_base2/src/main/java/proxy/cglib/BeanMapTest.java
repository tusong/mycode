package proxy.cglib;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy.cglib
 * @ClassName BeanMapTest.java
 * @date 2021/7/6
 * @Description: 此处添加类描述……
 * 我们使用BeanGenerator生成了一个含有两个属性的Java Bean，对其进行赋值操作后，生成了一个BeanMap对象，通过获取值来进行验证
 */
public class BeanMapTest {
//    @Test
//    public void testBeanMap() throws Exception{
//        BeanGenerator generator = new BeanGenerator();
//        generator.addProperty("username",String.class);
//        generator.addProperty("password",String.class);
//        Object bean = generator.create();
//        Method setUserName = bean.getClass().getMethod("setUsername", String.class);
//        Method setPassword = bean.getClass().getMethod("setPassword", String.class);
//        setUserName.invoke(bean, "admin");
//        setPassword.invoke(bean,"password");
//        BeanMap map = BeanMap.create(bean);
//        Assert.assertEquals("admin", map.get("username"));
//        Assert.assertEquals("password", map.get("password"));
//    }
}
