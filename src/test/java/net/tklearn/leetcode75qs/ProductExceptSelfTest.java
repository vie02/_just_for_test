package net.tklearn.leetcode75qs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.tklearn.leetcode75qs.ProductExceptSelf.productExceptSelf;

public class ProductExceptSelfTest {
    @Test
    public void test() {
        Assertions.assertArrayEquals(productExceptSelf(new int[] {1,2,3,4})
                , new int[]{24,12,8,6});
    }
}
