public class TestClass {


    public static void main(String[] args) {

        System.out.println(t());
    }

    public static boolean t(){

        try{
            if(true){
                throw new Exception();
            }
        }catch (Exception e){
            return false;
        }finally {

            System.out.println("finally");
        }

        return true;
    }
}
