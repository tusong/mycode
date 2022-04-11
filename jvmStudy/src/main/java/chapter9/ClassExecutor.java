package chapter9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassExecutor {

    /**
     * 执行外部传过来的代表一个java类的数组
     * 将输入类中的代表java.lang.System的CONSTANT_Utf8_info的常量改为HackSystem类型
     * 执行该类的 static void mian 方法，输出结果为该类想System.out/err的信息
     * @param classByte
     * @return
     */
    public static String execute(byte[] classByte){

        ClassModifier classModifier = new ClassModifier(classByte);
        byte[] bytes = classModifier.modifyUTF8Constant("java/lang/System", "chapter/HackSystem");
        HotSwapClassLoader hotSwapClassLoader = new HotSwapClassLoader();
        Class aClass = hotSwapClassLoader.loadByte(bytes);

        try {
            Method main = aClass.getMethod("main", new Class[]{String[].class});
            main.invoke(null,new String[]{null});
        } catch (Exception e) {
            e.printStackTrace();
        }


        return HackSystem.getBufferString();
    }
}
