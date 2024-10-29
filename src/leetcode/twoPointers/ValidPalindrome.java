package leetcode.twoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        var lettersOnly = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0; i < lettersOnly.length() / 2; i++) {
            if (lettersOnly.charAt(i) != lettersOnly.charAt(lettersOnly.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
