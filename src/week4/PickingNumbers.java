package week4;

import java.util.List;
import java.util.stream.Collectors;

public class PickingNumbers {

    public static void main(String[] args) {
        System.out.println(pickingNumbers(List.of(1, 1, 2, 2, 4, 4, 5, 5, 5)));
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
}
