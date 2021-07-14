package gc;


public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("i am is alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
//因为finalizer方法 暂停500毫秒以等待它
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("i am dead");
        }

        //下面的代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("i am dead");
        }

    }
}
