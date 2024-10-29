package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> isomorphicMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            isomorphicMap.putIfAbsent(s.charAt(i), t.charAt(i));
            tMap.putIfAbsent(t.charAt(i), s.charAt(i));
            var chS = isomorphicMap.getOrDefault(s.charAt(i), null);
            var chT = tMap.getOrDefault(t.charAt(i), null);
            if (t.charAt(i) != chS || s.charAt(i) != chT) return false;

        }
        return true;
    }
}
