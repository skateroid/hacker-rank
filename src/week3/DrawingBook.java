package week3;

public class DrawingBook {

    public static void main(String[] args) {
//        System.out.println(pageCount(100, 40));
//        System.out.println(pageCount(6, 2));
//        System.out.println(pageCount(5, 4));
//        System.out.println(pageCount(73201, 57075));
//        System.out.println(pageCount(2, 1));
        System.out.println(pageCount(7, 3));
    }

    public static int pageCount(int n, int p) {
        // Write your code here
        if (n <= 3) {
            return 0;
        }
        if (p == n - 1 && n % 2 == 0) {
            return 1;
        }
        if (p == 1 || p == n || p == n - 1) {
            return 0;
        }
        int mid = n / 2;
        if (p <= mid) {
            return p / 2;
        } else {
            return (n - p) / 2;
        }
    }
}
