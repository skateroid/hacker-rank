package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(maximumPerimeterTriangle(List.of(1, 2, 3, 4, 5, 10))
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here
        var sortedList = sticks.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        long maxPerimeter = -1;
        var result = new int[3];
        for (int i = 0; i < sortedList.size() - 2; i++) {
            long aSide = sortedList.get(i);
            for (int j = i + 1; j < sortedList.size() - 1; j++) {
                long bSide = sortedList.get(j);
                for (int k = i + 2; k < sortedList.size(); k++) {
                    long cSide = sortedList.get(k);

                    if (aSide + bSide > cSide
                            && aSide + cSide > bSide
                            && bSide + cSide > aSide) {
                        long perimeter = aSide + bSide + cSide;

                        if (perimeter > maxPerimeter) {
                            maxPerimeter = perimeter;
                            result[0] = (int) aSide;
                            result[1] = (int) bSide;
                            result[2] = (int) cSide;
                        }
                    }
                }
            }
        }

        return maxPerimeter != -1
                ? Arrays.stream(result).sorted().boxed().toList()
                : List.of(-1);
    }
}
