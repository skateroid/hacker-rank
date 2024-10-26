package leetcode;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        Arrays.stream(nums).boxed().peek(System.out::println).toList();
    }

    public static void rotate(int[] nums, int k) {
        int realK = k % nums.length;
        int[] buffer = new int[realK];
        System.arraycopy(nums, nums.length - realK, buffer, 0, realK);
        System.arraycopy(nums, 0, nums, realK, nums.length - realK);
        System.arraycopy(buffer, 0, nums, 0, realK);
    }
}
