package com.lizhaoxuan.leetcode.array;

/**
 * LeetCode#88 : 合并两个有序数组
 * @author lizhaoxuan
 * @date 2022/01/07
 */
public class MergeSortArray {

    /**
     * 两个数组都是有序的，顺序遍历合并即可。暴力解法，按照顺序拷贝到新的数组，再拷贝回nums1
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public void force(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n){
            // 按顺序拷贝
            if (nums1[i] <= nums2[j]){
                merge[k++] = nums1[i++];
            }else {
                merge[k++] = nums2[j++];
            }
        }
        // 拷贝剩余元素
        while (i < m){
            merge[k++] = nums1[i++];
        }
        while (j < n){
            merge[k++] = nums2[j++];
        }
        // 新数组拷贝回num1
        for (int r=0;r<merge.length;r++){
            nums1[r] = merge[r];
        }
    }


    /**
     * 两个数组都是有序的，顺序遍历合并即可。由于要求将合并后的数组更新到nums1，因此需要遍历nums1和nums2，顺序拷贝进nums1
     * 由于nums2拷贝进nums1会覆盖原有nums1的值，因此可以考虑从nums1的末尾往前拷贝。
     * 时间复杂度O(N)，空间复杂度O(1)
     */
    public void fromEnd(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        // 从后往前拷贝
        while (i >= 0 && j >= 0){
            if (nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
        // 拷贝剩余数组
        while (i >= 0){
            nums1[k--] = nums1[i--];
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }



}
