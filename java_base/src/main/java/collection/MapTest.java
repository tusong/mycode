package collection;

import function.MyFunction;
import function.entity.MyData;
import function.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tusong
 * @version V1.0
 * @Package collection
 * @ClassName MapTest.java
 * @date 2021/7/13
 * @Description: 此处添加类描述……
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Object> updParam = new HashMap<String, Object>() {
            {
                put("asset_sns", "asset_sns");
                put("system_user_id","system_user_id");
                put("system_user_name","system_user_name");
            }
        };

        MyFunction myFunction = new MyFunction() {

            {
                getData();
            }

            @Override
            public Object map(Object o) {
                return null;
            }

            @Override
            public MyData<User> getData() {
                return null;
            }

            @Override
            public MyData<? extends User> getData1() {
                return null;
            }

            @Override
            public MyData<? super User> getData2() {
                return null;
            }

            @Override
            public void setData(MyData data) {

            }

            @Override
            public void setData1(MyData data) {

            }

            @Override
            public void setData2(MyData data) {

            }
        };

    }
}
