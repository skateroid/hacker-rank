package week3;

import java.util.List;
import java.util.stream.Collectors;

public class SalesByMatch {

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        return ar.stream()
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()))
                .values()
                .stream()
                .mapToInt(count -> (int) (count / 2))
                .sum();
    }
}
