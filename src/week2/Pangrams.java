package week2;

import java.util.stream.Collectors;

public class Pangrams {

    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize "));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize   "));
        assert "pangram".equals(pangrams("We promptly judged antique ivory buckles for the next prize "));
        assert "not pangram".equals(pangrams("We promptly judged antique ivory buckles for the prize   "));
    }

    public static String pangrams(String s) {
        // Write your code here
        int lettersAmount = 26;
        var noSpaceString = s.replaceAll(" ", "").toLowerCase();
        var map = noSpaceString.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        if (map.entrySet().size() == lettersAmount) {
            return "pangram";
        } else {
            return "not pangram";
        }
    }
}
