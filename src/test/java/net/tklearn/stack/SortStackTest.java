package net.tklearn.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class SortStackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(Arrays.toString(stack.toArray()));
        SortStack.sortStack(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }
}
