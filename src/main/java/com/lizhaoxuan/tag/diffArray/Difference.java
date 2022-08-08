package com.lizhaoxuan.tag.diffArray;

import java.util.Arrays;

/**
 *    差分数组工具类
 * @author lizhaoxuan
 */
public class Difference {

        // 差分数组
        private int[] diff;

        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i=1;i<nums.length;i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }

        // 对区间[i,j]的所有元素增加value
        public void increment(int i, int j, int value){
            assert i >= 0;
            assert j >= 0;
            if (i > j){
                return;
            }
            diff[i] += value;
            if (j + 1 < diff.length){
                // j在数组区间内，在减少
                diff[j + 1] -= value;
            }
        }

        // 获取计算后的数组
        public int[] getResult(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i=1;i<diff.length;i++){
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }

    public static void main(String[] args) {
        Difference difference = new Difference(new int[]{1, 2, 4, 1, 0, 9, -2, -5, 3});
        difference.increment(1, 3, 2);
        difference.increment(2, 6, -4);
        difference.increment(3, 4, 3);
        System.out.println(Arrays.toString(difference.getResult()));
    }

}
