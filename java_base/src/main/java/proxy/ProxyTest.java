package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy
 * @ClassName ProxyTest.java
 * @date 2021/7/5
 * @Description: 此处添加类描述……
 */
public class ProxyTest {


    interface A {
        int a();
    }

    interface B {
        int b();
    }

    static class AImpl implements A,B{

        @Override
        public int a(){

            System.out.println("a");

            return 2;
        }

        @Override
        public int b(){

            System.out.println("b");

            return 2;
        }
    }

    public static void main(String[] args) {

        try {

            A aImpl = new AImpl();

            A a = getProxy(aImpl);
            int r = a.a();

            System.out.println("a instanceof A:"+(a instanceof A));
            System.out.println("a instanceof B:"+(a instanceof B));

            System.out.println(r);

        }catch (Exception e){
            System.err.println(e);
        }


    }

    public static A getProxy(A a){

        return (A) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{A.class,B.class}, new InvocationHandler() {


            /**
             * 处理代理实例上的方法调用并返回结果。当方法在与之关联的代理实例上调用时，将在调用处理程序上调用此方法。
             * @param proxy 调用方法的代理实例
             * @param method 对应于在代理实例上调用的接口方法的method实例。Method对象的声明类将是在其中声明方法的接口，它可能是代理类通过代理接口继承方法的代理接口的超接口。
             * @param args 一个包含在代理实例上的方法调用中传递的参数值的对象数组，或者如果接口方法不接受参数则为null。基本类型的参数被包装在适当的基本包装类的实例中，例如java.lang.Integer或java.lang.Boolean。
             * @return 从代理实例上的方法调用返回的值。如果接口方法声明的返回类型是基元类型，则该方法返回的值必须是相应基元包装类的实例;否则，它必须是可分配给声明的返回类型的类型。如果此方法返回的值为null，且接口方法的返回类型为原语，则在代理实例上的方法调用将引发NullPointerException。如果此方法返回的值与上述接口方法声明的返回类型不兼容，则在代理实例上的方法调用将引发ClassCastException。
             * @throws Throwable 从代理实例上的方法调用中抛出的异常。异常的类型必须可以赋值给接口方法的throws子句中声明的任何异常类型，也可以赋值给未检查的异常类型java.lang.RuntimeException或java.lang.Error。如果这个方法检查异常,不分配任何的异常类型中声明抛出接口方法的条款,然后一个UndeclaredThrowableException包含由该方法抛出的异常抛出的代理实例上的方法调用。
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//                System.out.println(proxy);
                System.out.println(method);
                System.out.println(args);

                Object r = method.invoke(a,args);

                return r;
            }
        });

    }

}
