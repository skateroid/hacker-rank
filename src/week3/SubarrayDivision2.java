package week3;

import java.util.List;

public class SubarrayDivision2 {

    public static void main(String[] args) {
        System.out.println(birthday(List.of(2, 2, 1, 3, 2), 4, 2));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int counter = 0;
        for (int i = 0; i < s.size() - m + 1; i++) {
            var subListSum = s.subList(i, i + m).stream()
                    .reduce(Integer::sum);
            if (subListSum.isPresent() && subListSum.get().equals(d)) {
                counter++;
            }
        }

        return counter;
    }
}
