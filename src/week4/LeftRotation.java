package week4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {

    public static void main(String[] args) {
        System.out.println(rotateLeft(4, List.of(1, 2, 3, 4, 5))
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int realMove = d % arr.size();
        int[] sourceArray = arr.stream().mapToInt(Integer::intValue).toArray();
        int[] resultArray = new int[arr.size()];
        System.arraycopy(sourceArray, realMove, resultArray, 0, arr.size() - realMove);
        System.arraycopy(sourceArray, 0, resultArray, arr.size() - realMove, realMove);

        return Arrays.stream(resultArray).boxed().toList();
    }
}
