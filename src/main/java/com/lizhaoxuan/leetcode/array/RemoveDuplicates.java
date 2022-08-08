package com.lizhaoxuan.leetcode.array;

/**
 * LeetCode#26 : 删除有序数组中的重复项
 * @author lizhaoxuan
 * @date 2022/01/07
 */
public class RemoveDuplicates {

    /**
     * nums有序，相等的元素必然相邻，暴力解法，将不同的元素拷贝到新数组即可
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public int force(int[] nums) {
        if (nums.length < 1){
            return nums.length;
        }
        int[] diff = new int[nums.length];
        int j = 0;
        for (int i=0;i<nums.length;i++){
            if (i == 0 || nums[i] != nums[i-1]){
                diff[j++] = nums[i];
            }
        }
        return diff.length;
    }

    /**
     * nums有序，相等的元素必然相邻，由于要求原地，则必须用非重复的数字覆盖重复的，将所有不重复数据移动到左边
     * 因此需要两个指针，一个用于扫描遍历，一个用于指向下一个可以覆盖位置的下标
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public int twoPoint(int[] nums) {
        if (nums.length < 1){
            return nums.length;
        }
        int fast = 0;
        int low = 0;
        while (fast < nums.length){
            if (fast == 0 || nums[fast] != nums[fast-1]){
                nums[low++] = nums[fast];
            }
            fast++;
        }
        return low;
    }

}
