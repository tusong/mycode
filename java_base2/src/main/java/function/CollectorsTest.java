package function;

import function.entity.Department;
import function.entity.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tusong
 * @version V1.0
 * @Package function
 * @ClassName CollectorsTest.java
 * @date 2021/7/12
 * @Description: 此处添加类描述……
 */
public class CollectorsTest {

    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        // 将Stream转换成容器或Map
        //<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
        //目标容器 ，元素如何添加到容器中，多个部分结果如何合并
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList()); // (1)
 Set<String> set = list.stream().collect(Collectors.toSet()); // (2)
 Map<String, Integer> map = set.stream().collect(Collectors.toMap(Function.identity(), String::length)); // (3)

        // 使用toCollection()指定规约容器的类型
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));// (3)
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));// (4)

        // Group employees by department
        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // 使用下游收集器统计每个部门的人数
        Map<Department, Long> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));// 下游收集器

        // 按照部门对员工分布组，并只保留员工的名字
        Map<Department, List<String>> byDept2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName,// 下游收集器
                                Collectors.toList())));// 更下游的收集器
    }
}
