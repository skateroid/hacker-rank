package week2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LonelyInteger {

    public static void main(String[] args) {
        System.out.println(lonelyinteger(List.of(1, 2, 3, 4, 3, 2, 1)));
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        return a.stream()
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(it -> it.getValue() == 1)
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getKey();
    }
}
