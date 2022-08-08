package com.lizhaoxuan.tag.prefixSum;

/**
 *  【LC-303】区域和检索 - 数组不可变
 * @author lizhaoxuan
 */
public class LC_303 {

    static class NumArray {
        private int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i=left;i<=right;i++){
                sum += nums[i];
            }
            return sum;
        }
    }

    static class NumArray2 {
        private int[] prefixSum;

        public NumArray2(int[] nums) {
            prefixSum = new int[nums.length + 1];
            prefixSum[0] = 0;
            for (int i=1;i<prefixSum.length;i++){
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right+1] - prefixSum[left];
        }
    }

    public static void main(String[] args) {
        NumArray2 numArray2 = new NumArray2(new int[]{-2,0,3,-5,2,-1});
        System.out.println(numArray2.sumRange(0,2));
        System.out.println(numArray2.sumRange(2,5));
        System.out.println(numArray2.sumRange(0,5));
    }

}
