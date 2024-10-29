package leetcode.twoPointers;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("b", "c"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int sPointer = 0;
        int tPointer = 0;
        while (tPointer != t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
            if (sPointer == s.length()) {
                return true;
            }
        }

        return false;
    }
}
