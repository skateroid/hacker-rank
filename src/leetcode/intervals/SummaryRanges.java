package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(String.join(" ", summaryRanges(new int[]{0, 1, 2, 4, 5, 7})));
        System.out.println(String.join(" ", summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return List.of();
        if (nums.length == 1) return List.of(valueOf(nums[0]));
        List<String> result = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                buffer.add(nums[i]);
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                buffer.add(nums[i]);
            } else {
                bufferToResult(buffer, result);
                buffer = new ArrayList<>();
                buffer.add(nums[i]);
            }
        }
        bufferToResult(buffer, result);
        return result;
    }

    private static void bufferToResult(List<Integer> buffer, List<String> result) {
        if (buffer.size() == 1) {
            result.add(valueOf(buffer.get(0)));
        } else {
            result.add(String.join("->", valueOf(buffer.get(0)), valueOf(buffer.get(buffer.size() - 1))));
        }
    }
}
