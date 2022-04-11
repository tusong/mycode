package chapter9;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    static {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    }

    interface IHello{
        void sayHello();
        void putHello();
    }

    static class Hello implements IHello{
        public void sayHello(){
            System.out.println("hello");
        }
        public void putHello(){}
    }

    static class DynamicProxy implements InvocationHandler {
        Object originObj;
        Object bind(Object obj){
            this.originObj = obj;

            return Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originObj,args);
        }
    }

    public static void main(String[] args) {


        IHello hello = new Hello();
        IHello proxy = (IHello) new DynamicProxy().bind(hello);

        proxy.sayHello();




    }

}
