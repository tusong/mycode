import java.math.BigDecimal;

public class TestClass {
    public static void main(String[] args) {

        long payCharge = 15000;
        long charge = 14442;
        charge =charge+payCharge;
        long total_latefee = 5506;
        BigDecimal total_latefeeBig = new BigDecimal(payCharge)

                .multiply(new BigDecimal(total_latefee))
                .divide(new BigDecimal(charge+""),0,BigDecimal.ROUND_HALF_UP)
//                .setScale(0,BigDecimal.ROUND_HALF_UP)
//                .longValue()
                ;
        System.out.println(total_latefeeBig);
    }
}
