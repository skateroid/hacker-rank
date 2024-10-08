package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XorStrings3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.get(0).length(); i++) {
            result.append(input.get(0).charAt(i) ^ input.get(1).charAt(i));
        }
        System.out.println(result);
    }
}
