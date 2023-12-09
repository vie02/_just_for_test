package net.tklearn.leetcode75qs;

public class MoveZeroes {
    /*
     Solution 1: bubble 0 to last ==> only beat 6%
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

    /*
    * Solution 2: 2 pointers: one for filling numbers, one to get numbers
    * */
    public static void moveZeroes2(int[] nums) {
        int start = -1; // pointer to fill non-zero numbers from start
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                start++;
                nums[start] = nums[i];
            }
        }
        for (int i = start+1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
