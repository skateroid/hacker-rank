package leetcode.twoPointers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TwoSum2 {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 18))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] ==target) {
                result[0] = left + 1;
                result[1] = right + 1;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
