package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SparseArrays {

    public static void main(String[] args) {
        var strings = List.of("ab", "ab", "abc");
        var queries = List.of("ab", "abc", "bc");
        System.out.println(matchingStrings(strings, queries).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        Map<String, Long> map = strings.stream().collect(Collectors.groupingBy(it -> it, Collectors.counting()));
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            result.add(map.getOrDefault(query, 0L).intValue());
        }
        return result;
    }
}
