package leetcode.hashmap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        var magazineMap = Arrays.stream(magazine.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        for (String s : ransomNote.split("")) {
            var value = magazineMap.getOrDefault(s, null);
            if (value != null && value != 0) {
                magazineMap.computeIfPresent(s, (k, v) -> --v);
            } else {
                return false;
            }
        }
        return true;
    }
}
