package proxy;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy
 * @ClassName ProxyCglibTest.java
 * @date 2021/7/5
 * @Description: 此处添加类描述……
 */
public class ProxyCglibTest {


    static class A {
        public void a(){

            System.out.println("a");
        }
    }

    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(A.class);
////        enhancer.setCallback(new MethodInterceptor() {
////            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
////
////                System.out.println("before");
////
////                Object result = methodProxy.invokeSuper(o,objects);
////
////                System.out.println("after");
////
////                return null;
////            }
////        });
//
////        enhancer.setCallback(new InvocationHandler() {
////            @Override
////            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
////                System.out.println("InvocationHandler before");
////
////                //o为代理对象，不要调用代理对象的method方法，此处会导致无限循环
////                Object result = method.invoke(o,objects);
////
////                System.out.println("InvocationHandler after");
////                return null;
////            }
////        });
//
//        A a = (A) enhancer.create();
//        a.a();
////        System.out.println(a.toString());
////        System.out.println(a.hashCode());
////        System.out.println(a.getClass());

    }


}
