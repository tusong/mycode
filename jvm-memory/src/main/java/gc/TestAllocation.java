package gc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * -verbose:gc -Xms20m -Xmx20m -Xmn=10m
 * 设置堆的大小为20m且不可扩展，新生代为10m
 * -XX:SurvivorRatio=8 决定了新生代中eden区与一个survivor区的空间比例为8比1
 * -XX:+PrintGCDetails
 *
 */
public class TestAllocation {

    public static final int _1M = 1024*1024;

//    public static void main(String[] args) {
//        byte[] allocation1,allocation2,allocation3,allocation4;
//
//        allocation1 = new byte[2*_1M];
//        allocation2 = new byte[2*_1M];
//        allocation3 = new byte[2*_1M];
//        allocation4 = new byte[4*_1M];
//
//    }

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");//设置日期格式
        String d = df.format(new Date());
        System.out.println(d);
    }

}
