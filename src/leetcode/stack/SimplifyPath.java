package leetcode.stack;

import java.util.ArrayDeque;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        var pathArr = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String s : pathArr) {
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.remove();
                }
                continue;
            }
            deque.push(s);
        }
        var result = new StringBuilder();
        deque.descendingIterator()
                .forEachRemaining(it -> result.append("/").append(it));
        return result.toString().isEmpty() ? "/" : result.toString();
    }
}
