package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * @author tusong
 * @version V1.0
 * @Package function
 * @ClassName StreamDemo.java
 * @date 2021/7/11
 * @Description: 此处添加类描述……
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "bug", "ABC", "Dog");
        strings = new ArrayList<>(strings);
        OptionalInt max
                = strings.stream()
                //无状态中间操作
                .filter(s -> s.startsWith("A"))
                //无状态中间操作
                .mapToInt(String::length)
                //有状态中间操作
                .sorted()
                //非短路终端操作
                .max();
    }
}
