package chapter13.java1;


public class Memory {

    public static void main(String[] args) { //line1

        int i = 1;//line2
        Object obj = new Object();//line3
        Memory memory = new Memory();//line4
        memory.foo(obj);//line5

    }//line9

    private void foo(Object param){//line6
        String str = param.toString();//line7
        System.out.println(str);
    }//line8
}
