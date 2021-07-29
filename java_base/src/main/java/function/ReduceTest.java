package function;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author tusong
 * @version V1.0
 * @Package function
 * @ClassName ReduceTest.java
 * @date 2021/7/12
 * @Description: 此处添加类描述……
 */
public class ReduceTest {

    /**
     * reduce操作可以实现从一组元素中生成一个值，sum()、max()、min()、count()等都是reduce操作，将他们单独设为函数只是因为常用。
     * reduce()的方法定义有三种重写形式：
     * Optional<T> reduce(BinaryOperator<T> accumulator) 累加器
     * T reduce(T identity, BinaryOperator<T> accumulator) 初始值，累加器
     * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)初始值，累加器，组合器
     */
    public static void main(String[] args) {
        // 找出最长的单词![](http://images2015.cnblogs.com/blog/939998/201703/939998-20170314192638495-351834305.png)

        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Optional<String> longest = stream.reduce((s1, s2) -> s1.length()>=s2.length() ? s1 : s2);
//Optional<String> longest = stream.max((s1, s2) -> s1.length()-s2.length());
        System.out.println(longest.get());



    }

    int sum(){
        // 求单词长度之和
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Integer lengthSum = stream.reduce(0,// 初始值　// (1)
        (sum, str) -> sum+str.length(), // 累加器 // (2)
                (a, b) -> a+b);// 部分和拼接器，并行执行时才会用到 // (3)
// int lengthSum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
                return lengthSum;
    }

}
