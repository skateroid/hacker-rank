package leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        var str = s.split(" ");
        var chars = pattern.toCharArray();
        if (chars.length != str.length) return false;
        Map<Character, Set<String>> patternMap = new HashMap<>();
        Set<String> usedS = new HashSet<>();
        int sCount = 0;
        for (char ch : chars) {
            var set = patternMap.getOrDefault(ch, new HashSet<>());
            if (set.isEmpty()) {
                if (usedS.contains(str[sCount])) {
                    return false;
                }
                set.add(str[sCount]);
                usedS.add(str[sCount]);
            } else if (!set.contains(str[sCount])) {
                return false;
            }
            patternMap.putIfAbsent(ch, set);
            sCount++;
        }
        return true;
    }
}
