package m;

/**
 * VM Args：-Xss2M
 */
public class JavaVmStackOOM {

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM javaVmStackOOM = new JavaVmStackOOM();

        javaVmStackOOM.stackLeakByThread();
    }
}
