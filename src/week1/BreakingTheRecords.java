package week1;

import java.util.List;

public class BreakingTheRecords {

    public static void main(String[] args) {
        breakingRecords(List.of(12, 24, 10, 24)).forEach(System.out::println);
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int minCount = 0;
        int maxCount = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                min = scores.get(i);
                max = scores.get(i);
                continue;
            }
            if (scores.get(i) < min) {
                minCount++;
                min = scores.get(i);
            } else if (scores.get(i) > max) {
                maxCount++;
                max = scores.get(i);
            }
        }

        return List.of(maxCount, minCount);
    }
}
