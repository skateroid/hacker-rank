package leetcode.stringArray;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates2 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int bufferCount = 0;
        int[] buffer = new int[nums.length];
        for (int num : nums) {
            var currentCount = 1;
            if (map.getOrDefault(num, null) == null) {
                map.put(num, currentCount);
                buffer[bufferCount] = num;
                bufferCount++;
            } else if (map.get(num) == 1){
                map.computeIfPresent(num, (k, v) -> ++v);
                buffer[bufferCount] = num;
                bufferCount++;
            }
        }
        System.arraycopy(buffer, 0, nums, 0, bufferCount);

        return bufferCount;
    }
}
