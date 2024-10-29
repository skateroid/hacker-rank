package leetcode.stringArray;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 1, 2, 2, 3, 0, 4, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int bufferCount = 0;
        int[] buffer = new int[nums.length];
        for (int num : nums) {
            if (map.getOrDefault(num, null) == null) {
                map.put(num, 1);
                buffer[bufferCount] = num;
                bufferCount++;
            }
        }
        System.arraycopy(buffer, 0, nums, 0, map.size());

        return map.size();
    }
}
