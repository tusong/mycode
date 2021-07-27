package proxy;

/**
 * @author tusong
 * @version V1.0
 * @Package proxy
 * @ClassName ProxyCglibTest.java
 * @date 2021/7/5
 * @Description: 此处添加类描述……
 */
public class ProxyCglibFilterTest {


    static class A {
        public void a(){

            System.out.println("a");
        }
    }

    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(A.class);
//        enhancer.setCallback(new FixedValue() {
//            @Override
//            public Object loadObject() throws Exception {
//                return "aaaa";
//            }
//        });
//
//        CallbackHelper callbackHelper = new CallbackHelper(A.class,null) {
//            @Override
//            protected Object getCallback(Method method) {
//
//                if(method.getDeclaringClass() != Object.class){
//
//                }
//
//                return NoOp.INSTANCE;
//            }
//        };
//
//        A a = (A) enhancer.create();
//        a.a();
////        System.out.println(a.toString());
////        System.out.println(a.hashCode());
////        System.out.println(a.getClass());
//
    }


}
