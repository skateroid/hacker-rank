package leetcode.stack;

import java.util.ArrayDeque;

public class MinStack {

    public static void main(String[] args) {
        var minStack = new MinStackImpl();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    static class MinStackImpl {

        private final ArrayDeque<Integer> stack;
        private final ArrayDeque<Integer> minStack;

        public MinStackImpl() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            var currentMin = minStack.peek();
            if (currentMin != null) {
                if (val < currentMin) {
                    minStack.push(val);
                } else {
                    minStack.push(currentMin);
                }
            } else {
                minStack.push(val);
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
