package week2;

import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        System.out.println(diagonalDifference(List.of(List.of(11, 2, 4), List.of(4, 5, 6), List.of(10, 8, -12))));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int i = 0;
        int j = arr.size() - 1;
        int diagonal1 = 0;
        int diagonal2 = 0;

        for (List<Integer> integers : arr) {
            diagonal1 += integers.get(i);
            diagonal2 += integers.get(j);
            i++;
            j--;
        }

        return Math.abs(diagonal1 - diagonal2);
    }
}
