package week1;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSumPairs {

    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2)));
        System.out.println(divisibleSumPairs(6, 5, List.of(1, 2, 3, 4, 5, 6)));
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        List<List<Integer>> resultPairs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                var sum = ar.get(i) + ar.get(j);
                if (sum % k == 0) {
                    resultPairs.add(List.of(ar.get(i), ar.get(j)));
                }
            }
        }
        return resultPairs.size();
    }
}
