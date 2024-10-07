package week2;

public class FlippingBits {

    public static void main(String[] args) {
        System.out.println(flippingBits(1));
        System.out.println(flippingBits(2147483647));
    }

    public static long flippingBits(long n) {
        // Write your code here
        return ~n & 0xFFFFFFFFL;
    }
}
