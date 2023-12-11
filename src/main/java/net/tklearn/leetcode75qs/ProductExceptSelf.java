package net.tklearn.leetcode75qs;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] r = new int[nums.length];
        Arrays.fill(r, 1);
        for (int i = 1; i<nums.length; i++) {
            r[i] = r[i-1]*nums[i-1];
        }
        int suf_prod = 1;
        for (int i = nums.length-2; i>-1; i--) {
            suf_prod *= nums[i+1];
            r[i] = r[i] * suf_prod;
        }

        return r;
    }
}
