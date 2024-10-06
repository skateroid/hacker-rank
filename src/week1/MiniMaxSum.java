package week1;

import java.util.Arrays;
import java.util.List;

public class MiniMaxSum {

    public static void main(String[] args) {
        var arr = List.of(3, 9, 2, 4, 1);
        miniMaxSum(arr);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        var array = arr.toArray(Integer[]::new);
        Arrays.sort(array);

        long min = 0;
        long max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) min += array[0];
            else if (i == array.length - 1) max += array[array.length - 1];
            else {
                min += array[i];
                max += array[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
