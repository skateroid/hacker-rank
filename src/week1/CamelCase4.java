package week1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CamelCase4 {

//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
//         Your class should be named Solution. */
//        var input = List.of("S;M;plasticCup()", "C;V;mobile phone", "C;C;coffee machine",
//                "S;C;LargeSoftwareBook", "C;M;white sheet of paper", "S;V;pictureFrame");
//        for (String value : input) {
//            splitCombine(value);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            splitCombine(scanner.nextLine());
        }
    }

    private static void splitCombine(String value) {
        String[] values = value.split(";");
        var chars = values[2].toCharArray();
        var result = new StringBuilder();
        if (values[0].equals("S")) {
            switch (values[1]) {
                case "C" -> {
                    toLowerCase(chars, result, chars.length);
                    System.out.println(result.toString().trim());
                }
                case "M" -> {
                    toLowerCase(chars, result, chars.length - 2);
                    System.out.println(result);
                }
                case "V" -> {
                    toLowerCase(chars, result, chars.length);
                    System.out.println(result);
                }
            }
        } else {
            toUpperCase(values, result);
            switch (values[1]) {
                case "C" -> System.out.println(result);
                case "M" -> System.out.println(result.substring(0, 1).toLowerCase() + result.substring(1) + "()");
                case "V" -> System.out.println(result.substring(0, 1).toLowerCase() + result.substring(1));
            }
        }
    }

    private static void toUpperCase(String[] values, StringBuilder result) {
        Arrays.stream(values[2].split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .forEach(result::append);
    }

    private static void toLowerCase(char[] chars, StringBuilder result, int end) {
        for (int i = 0; i < end; i++) {
            if (Character.isUpperCase(chars[i])) {
                result.append(" ").append(Character.toLowerCase(chars[i]));
            } else {
                result.append(chars[i]);
            }
        }
    }
}
