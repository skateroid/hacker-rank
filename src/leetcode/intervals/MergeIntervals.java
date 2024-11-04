package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {2, 3}})));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                var arr = new int[2];
                arr[0] = intervals[i][0];
                arr[1] = intervals[i][1];
                result.add(arr);
                continue;
            }
            var currentArr = intervals[i];
            if (currentArr[0] > result.get(result.size() - 1)[1]) {
                result.add(currentArr);
            } else {
                if (currentArr[1] >= result.get(result.size() - 1)[1]) {
                    result.get(result.size() - 1)[1] = currentArr[1];
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
