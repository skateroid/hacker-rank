package week4;

public class NumberLineJumps {

    public static void main(String[] args) {
        System.out.println(kangaroo(0, 5, 3, 3));
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if (v1 == v2 && x1 != x2) return "NO";
        int leftPart = x1 - x2;
        int firstRightPart = v2 - v1;
        if (leftPart == firstRightPart) return "YES";
        int firstDelta = Math.abs(Math.abs(leftPart) - Math.abs(firstRightPart));
        int count = 2;
        while (true) {
            int rightPart = count * (v2 - v1);
            int currentDelta = Math.abs(Math.abs(leftPart) - Math.abs(rightPart));
            if (firstDelta < currentDelta) {
                return "NO";
            }
            if (leftPart == rightPart) {
                return "YES";
            }
            count++;
        }
    }
}
