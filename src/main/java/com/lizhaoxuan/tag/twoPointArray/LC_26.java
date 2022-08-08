package com.lizhaoxuan.tag.twoPointArray;

/**
 * 【26】删除有序数组中的重复项
 * @author lizhaoxuan
 */
public class LC_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length){
            if (nums[slow] != nums[fast]){
                // 更新slow
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}