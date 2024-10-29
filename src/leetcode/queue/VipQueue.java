package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class VipQueue {
    public static void main(String args[]) {
        System.out.println("Hello, world!");

        CustomQueue vipQueue = new CustomQueue();
        vipQueue.add("1", true); // [1]
        vipQueue.add("2", true); // [1, 2]
        vipQueue.add("3", true); // [1, 3, 2]
        vipQueue.add("4", true); // [1, 3, 4, 2]
        vipQueue.add("5", false); // [1, 3, 4, 2, 5]
        System.out.println(vipQueue.get());
        System.out.println(vipQueue.get());
        System.out.println(vipQueue.get());
        System.out.println(vipQueue.get());
        System.out.println(vipQueue.get());
    }


    static class CustomQueue {

        private Deque<Customer> beginning = new ArrayDeque<>();
        private Deque<Customer> ending = new ArrayDeque<>();

        public void add(String id, boolean vip) {
            if (vip) {
                if (beginning.size() - ending.size() >= 2) {
                    var customer = beginning.pollLast();
                    ending.push(customer);
                }
                beginning.addLast(new Customer(id, true));
            } else {
                ending.addLast(new Customer(id, false));
                if (beginning.size() - ending.size() >= 2) {
                    var customer = ending.pollFirst();
                    beginning.addLast(customer);
                }
            }
        }

        public String get() {
            Deque<Customer> pollQueue;
            if (beginning.isEmpty()) {
                pollQueue = ending;
            } else {
                pollQueue = beginning;
            }
            var customer = pollQueue.pollFirst();
            if (ending.size() - beginning.size() >= 2) {
                var endCustomer = ending.pollFirst();
                beginning.addLast(endCustomer);
            }
            return customer.id;
        }
    }

    record Customer(String id, boolean vip) {
    }
}
