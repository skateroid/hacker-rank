package leetcode.stringArray;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
//        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> referencesMap = new HashMap<>();
        referencesMap.put("I", 1);
        referencesMap.put("V", 5);
        referencesMap.put("X", 10);
        referencesMap.put("L", 50);
        referencesMap.put("C", 100);
        referencesMap.put("D", 500);
        referencesMap.put("M", 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = referencesMap.get(String.valueOf(s.charAt(i)));
            if (i == s.length() - 1) {
                result += currentValue;
                break;
            }
            int nextValue = referencesMap.get(String.valueOf(s.charAt(i + 1)));
            if (currentValue >= nextValue) {
                result += currentValue;
            } else {
                result += nextValue - currentValue;
                i++;
            }
        }
        return result;
    }
}
