package chapter05.java1;

import java.util.Date;

public class LocalVariablesTest {

    int count;
    public static void main(String[] args) {
        LocalVariablesTest localVariablesTest = new LocalVariablesTest();
        int num = 10;
        localVariablesTest.test1();

    }

    public void test1(){
        Date date = new Date();
        String name1 = "tudayu";
        String info = test2(date,name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP,String name2){
        dateP = null;
        name2 = "tydic";
        double weight = 100;
        char gender = '男';
        return dateP + name2;
    }

    public void test3 (){
        count++;
    }

}
