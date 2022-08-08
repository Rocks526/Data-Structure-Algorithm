package com.lizhaoxuan.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode#1 : 两数之和
 * @author lizhaoxuan
 * @date 2022/01/06
 */
public class TowSum {

    /**
     * 双重for循环暴力解法
     * 时间复杂度O(n^2)，空间复杂度O(1)
     */
    public int[] force(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    /**
     * 先排序，再两头往中间遍历  ===>  不通过，排序会改变元素位置，导致返回下标不对
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public int[] sortAndTwoPoint(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if (nums[i] + nums[j] == target){
                return new int[]{i,j};
            }else if (nums[i] + nums[j] < target){
                i++;
            }else if (nums[i] + nums[j] > target){
                j--;
            }
        }
        return null;
    }


    /**
     * 计算两数之和的问题可以转换成：已知数A、B，求另外一个数C，满足A+B=C，如果C存在，输出在数组的下标，利用哈希表可以快速判断某个数是否存在
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public int[] hash(int[] nums, int target) {
        // 存储数组值和对应的下标
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        // 遍历数组，判断是否存在
        for (int i=0;i<nums.length;i++){
            int need = target - nums[i];
            // 判断是注意是否是同一个元素
            if (map.containsKey(need) && i != map.get(need)){
                return new int[]{i, map.get(need)};
            }
        }
        return null;
    }

    /**
     * 基于上面的hash方式，发现第一个构造hash和第二次寻找匹配元素时需要遍历两次，可以合二为一，一遍遍历一遍存
     * 时间复杂度O(N)，空间复杂度O(N)
     */
    public int[] hash2(int[] nums, int target) {
        // 存储数组值和对应的下标
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        // 遍历数组，判断是否存在
        for (int i=0;i<nums.length;i++){
            int need = target - nums[i];
            // 由于map里的元素总是慢于遍历的速度，因此不会出现同个元素计算的情况
            if (map.containsKey(need)){
                return new int[]{i, map.get(need)};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
