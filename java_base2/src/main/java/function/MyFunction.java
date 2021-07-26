package function;

import function.entity.MyData;
import function.entity.User;

import java.util.function.Function;

/**
 * @author tusong
 * @version V1.0
 * @Package function
 * @ClassName MyFunction.java
 * @date 2021/7/11
 * @Description: 此处添加类描述……
 */
public abstract class MyFunction<T, R> implements Function<T, R> {
    @Override
    public Object apply(Object o) {
        return null;
    }


    public abstract R map(T t);

    public abstract MyData<User> getData();

    public abstract MyData<? extends User> getData1();

    public abstract MyData<? super User> getData2();

    public abstract void setData(MyData<User> data);

    public abstract void setData1(MyData<? extends User> data);

    public abstract void setData2(MyData<? super User> data);

    public void getDataV(){
        MyData<? extends User> myData = getData();
        MyData<? extends User> myData1 = getData1();
        //编译出错
//        MyData<? extends User> myData2 = getData2();
        MyData<? super User> myData2 = getData2();
    }
    public void getDataV2(){
        MyData<User> myData = getData();
        //编译出错
//        MyData<User> myData1 = getData1();
//        //编译出错
//        MyData<User> myData2 = getData2();
    }

    public void setDataV(){

    }
    public void setDataV2(){

    }
}
