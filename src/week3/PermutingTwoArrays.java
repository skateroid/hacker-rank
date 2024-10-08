package week3;

import java.util.ArrayList;
import java.util.List;

public class PermutingTwoArrays {

    public static void main(String[] args) {
        System.out.println(twoArrays(10, List.of(2, 1, 3), List.of(7, 8, 9)));
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        List<Integer> usedSecondArrayValuePositions = new ArrayList<>();
        List<Integer> secondSorted = B.stream().sorted().toList();
        for (Integer outer : A) {
            var usedSecondSize = usedSecondArrayValuePositions.size();
            for (int i = 0; i < secondSorted.size(); i++) {
                if (usedSecondArrayValuePositions.contains(i)) continue;
                if (outer + secondSorted.get(i) >= k) {
                    usedSecondArrayValuePositions.add(i);
                    break;
                }
            }
            if (usedSecondArrayValuePositions.size() == usedSecondSize) return "NO";
        }
        if (usedSecondArrayValuePositions.size() == A.size()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
