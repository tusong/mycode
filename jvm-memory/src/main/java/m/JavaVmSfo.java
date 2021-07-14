package m;

public class JavaVmSfo {


    int stackLength = 0;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVmSfo javaVmSfo = new JavaVmSfo();

        try{

            javaVmSfo.stackLeak();

        }catch (Throwable e){
            System.out.printf("stack length:"+javaVmSfo.stackLength);
            throw e;
        }



    }


}
