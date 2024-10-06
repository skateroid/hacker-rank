package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class PlusMinus {

    public static void main(String[] args) {
        var arr = List.of(-4, 3, -9, 0, 4, 1);
        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for (int value : arr) {
            if (value < 0) neg++;
            else if (value == 0) zero++;
            else pos++;
        }
        System.out.println(BigDecimal.valueOf(pos).divide(BigDecimal.valueOf(n), 6, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(neg).divide(BigDecimal.valueOf(n), 6, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(zero).divide(BigDecimal.valueOf(n), 6, RoundingMode.HALF_UP));
    }
}
