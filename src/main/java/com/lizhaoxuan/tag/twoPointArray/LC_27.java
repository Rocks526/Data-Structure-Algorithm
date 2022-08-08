package com.lizhaoxuan.tag.twoPointArray;

/**
 * 【27】移除元素
 * @author lizhaoxuan
 */
public class LC_27 {

    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}