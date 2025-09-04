package net.tklearn.stack;

import java.util.Stack;

public class SortStack {

    /**
     * Sort a stack with O(n2) time and O(n) space
     * using additional stack
     * @param stack
     */
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > pop) {
                stack.push(sorted.pop());
            }
            sorted.push(pop);
        }
        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }
}
