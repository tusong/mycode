package chapter7;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *非主动使用类字段演示
 *
 * 通过数组定义来引用类，不会触发此类的初始化
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 **/
public class NotInitialization{
    public static void main(String[]args){
//        System.out.println(SubClass.value);
//        SuperClass[] sc = new SuperClass[10];
//        System.out.println(ConstClass.HELLOWORLD);
        SimpleDateFormat _shortSdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date from = _shortSdf.parse("20200901");
            Calendar cal = Calendar.getInstance();
            cal.setTime(from);
            String now = null;
            cal.set(Calendar.DATE, 1);
            cal.add(Calendar.MONTH, 1);
            cal.add(Calendar.DATE, -1);
            now = shortSdf.format(cal.getTime());
            System.out.println(now);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }}