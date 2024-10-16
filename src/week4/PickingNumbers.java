package week4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingNumbers {

    public static void main(String[] args) {
//        System.out.println(pickingNumbers(List.of(1, 1, 2, 2, 4, 4, 5, 5, 5)));
//        System.out.println(pickingNumbers(List.of(2, 2, 3, 3, 3, 4, 4, 4, 4, 5)));
//        System.out.println(pickingNumbers(List.of(4, 6, 5, 3, 3, 1)));
        System.out.println(pickingNumbers(List.of(4, 97, 5, 97, 97, 4, 97, 4, 97, 97, 97, 97, 4, 4, 5, 5, 97, 5, 97, 99, 4, 97, 5, 97, 97, 97, 5, 5, 97, 4, 5, 97, 97, 5, 97, 4, 97, 5, 4, 4, 97, 5, 5, 5, 4, 97, 97, 4, 97, 5, 4, 4, 97, 97, 97, 5, 5, 97, 4, 97, 97, 5, 4, 97, 97, 4, 97, 97, 97, 5, 4, 4, 97, 4, 4, 97, 5, 97, 97, 97, 97, 4, 97, 5, 97, 5, 4, 97, 4, 5, 97, 97, 5, 97, 5, 97, 5, 97, 97, 97)));
//        System.out.println(pickingNumbers(List.of(84, 43, 11, 41, 2, 99, 31, 32, 56, 53, 42, 14, 98, 27, 64, 57, 16, 33, 48, 21, 46, 61, 87, 90, 28, 12, 62, 49, 29, 77, 82, 70, 80, 89, 95, 52, 13, 19, 9, 79, 35, 67, 51, 39, 7, 1, 66, 8, 17, 85, 71, 97, 34, 73, 75, 6, 91, 40, 96, 65, 37, 74, 20, 68, 23, 47, 76, 55, 24, 3, 30, 22, 55, 5, 69, 86, 54, 50, 10, 59, 15, 4, 36, 38, 83, 60, 72, 63, 78, 58, 88, 93, 45, 18, 94, 44, 92, 81, 25, 26)));
    }

    public static int pickingNumbers(List<Integer> a) {
        int max = 0;
        var map = a.stream().collect(Collectors.groupingBy(it -> it, Collectors.counting()));
        var list = map.keySet().stream().sorted().toList();
        if (map.size() == 1) {
            return map.values().stream().findFirst().get().intValue();
        }
        for (int i = 0; i < list.size() - 1; i++) {
            var current = list.get(i);
            var next = list.get(i + 1);
            if (next - current == 1) {
                if (max < map.get(current) + map.get(next)) {
                    max = map.get(current).intValue() + map.get(next).intValue();
                }
            }
            if (map.get(current) > max) {
                max = map.get(current).intValue();
            }
        }

        return max;
    }

    public static int pickingNumbersOld(List<Integer> a) {
        // Write your code here
        int result = 0;
        int currentStart = 0;
        int currentLength = 0;
        var sorted = a.stream().sorted().toList();

        for (int i = 0; i < a.size(); i++) {
            if (i == 53) {
                System.out.println("!");
            }
            if (currentLength == 0) {
                currentStart = sorted.get(i);
                currentLength++;
                continue;
            }
            if (sorted.get(i) - currentStart <= 1) {
                currentLength++;
            } else {
                if (result < currentLength) {
                    result = currentLength;
                    currentLength = 1;
                    currentStart = sorted.get(i);
                }
            }

        }

        return Math.max(currentLength, result);
    }
}
