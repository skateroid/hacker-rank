package leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abccaqwebcbb"));
        System.out.println(lengthOfLongestSubstring("abccaqweb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int longestStr = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            var chR = s.charAt(right);
            if (!set.add(chR)) {
                longestStr = Math.max(longestStr, right - left);
                while (!set.add(chR)) {
                    set.remove(s.charAt(left));
                    left++;

                }
                set.add(chR);
            }
            right++;
        }
        longestStr = Math.max(longestStr, right - left);
        return longestStr;
    }
}
