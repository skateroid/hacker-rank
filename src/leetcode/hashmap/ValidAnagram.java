package leetcode.hashmap;

import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("cat", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        var sMap = new String(s.toCharArray()).chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        for (char ch : t.toCharArray()) {
            if (sMap.containsKey(ch) && sMap.get(ch) > 0) {
                sMap.computeIfPresent(ch, (k,v) -> --v);
            } else {
                return false;
            }
        }

        return true;
    }
}
