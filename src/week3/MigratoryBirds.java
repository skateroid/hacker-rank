package week3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(List.of(2, 2, 1, 1, 3)));
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        return arr.stream()
                .collect(Collectors.groupingBy(it -> it, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.<Integer, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .orElseThrow().getKey();

    }
}
