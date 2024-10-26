package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElement {

    public static void main(String[] args) {
//        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{2,2,1,3,1,1,4,1,1,5,1,1,6}));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger majorityElement = new AtomicInteger(nums[0]);
        AtomicInteger maxCount = new AtomicInteger(1);
        for (int num : nums) {
            map.computeIfPresent(num, (k, v) -> {
                ++v;
                if (v > maxCount.get()) {
                    majorityElement.set(k);
                    maxCount.set(v);
                }
                return v;
            });
            map.putIfAbsent(num, 1);
        }

        return majorityElement.get();
    }
}
