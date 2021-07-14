package generic;

import java.util.*;

public class SortTest {
    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> item = new HashMap<>();
        item.put("index",1);
        Map<String,Object> item2 = new HashMap<>();
        item2.put("index",2);
        list.add(item);
        list.add(item2);

        list.sort(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                int index1 = (int) o1.get("index");
                int index2 = (int) o2.get("index");

                int r1 = index1 - index2;

                return 0-r1;
            }
        });

        System.out.println(list.get(0).get("index"));
    }
}
