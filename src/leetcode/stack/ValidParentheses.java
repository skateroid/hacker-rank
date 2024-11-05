package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([]{})"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        var chars  = s.split("");
        Map<String, String> map = Map.of(
                ")", "(",
                "}", "{",
                "]", "["
        );
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String bracket : chars) {
            if ("({[".contains(bracket)) {
                stack.push(bracket);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                var last = stack.poll();
                if (!last.equals(map.get(bracket))) return false;
            }
        }
        return stack.isEmpty();
    }
}
