package week2;

public class MarsExploration {

    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSPSSQSSOR"));
    }

    public static int marsExploration(String s) {
        // Write your code here
        int result = 0;
        int sosLength = 3;
        int sosAmount = s.length() / sosLength;
        for (int i = 0; i < sosAmount; i++) {
            var substring = s.substring(i * sosLength, i * sosLength + sosLength);
            if (substring.charAt(0) != 'S') result++;
            if (substring.charAt(1) != 'O') result++;
            if (substring.charAt(2) != 'S') result++;
        }

        return result;
    }
}
