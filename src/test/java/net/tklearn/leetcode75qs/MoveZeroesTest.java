package net.tklearn.leetcode75qs;

import org.junit.jupiter.api.Test;

import static net.tklearn.leetcode75qs.MoveZeroes.moveZeroes;
import static net.tklearn.leetcode75qs.MoveZeroes.moveZeroes2;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTest {

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, arr);
    }
    @Test
    public void test2() {
        int[] arr = {1};
        moveZeroes(arr);
        assertArrayEquals(new int[]{1}, arr);
    }
    @Test
    public void test3() {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes2(arr);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, arr);
    }
    @Test
    public void test4() {
        int[] arr = {1};
        moveZeroes2(arr);
        assertArrayEquals(new int[]{1}, arr);
    }
}
