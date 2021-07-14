package function;

import function.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tusong
 * @version V1.0
 * @Package function
 * @ClassName StreamTest.java
 * @date 2021/7/11
 * @Description: 此处添加类描述……
 */
public class StreamTest {

    public static void main(String[] args) {

    }

    private List<String> list = new ArrayList<>();

    List<User> users;

    public void load() {
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");

        users = Arrays.asList(new User(1, "张三", 18),
                new User(2, "李四", 30),
                new User(3, "王五", 20),
                new User(4, "赵六", 18));

    }

    public void groupingBy() {
        users.stream().collect(Collectors.groupingBy(User::getAge)).forEach((key, value) -> {
            System.out.println(key + "  ---" + value);
        });
    }
}
