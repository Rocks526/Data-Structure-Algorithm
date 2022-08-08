package com.lizhaoxuan.tag.twoPointArray;

/**
 * 2.4 【283】移动零
 * @author lizhaoxuan
 */
public class LC_283 {

    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length){
            nums[slow++] = 0;
        }
    }

}