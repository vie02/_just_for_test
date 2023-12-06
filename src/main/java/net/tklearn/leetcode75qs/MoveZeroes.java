package net.tklearn.leetcode75qs;

public class MoveZeroes {
    /*
     Solution 1: bubble 0 to last ==> beat 6%
     */
    public static void moveZeroes(int[] nums) {
        int start = 0;
        for (int last = nums.length - 1; last > - 1; last--) {
            int i = start;
            while (i<nums.length && nums[i] != 0) {
                i++;
            }
            start = i;
            while (i < last) {
                nums[i] = nums[i+1];
                nums[i+1] = 0;
                i++;
            }
        }
    }
}
