package com.lizhaoxuan.leetcode.array;

import java.util.*;

/**
 * LeetCode#15 : 三数之和
 * @author lizhaoxuan
 * @date 2022/01/12
 */
public class ThreeSum {

    /**
     * 暴力解法，三重for循环计算，去重通过Set实现
     * 时间复杂度O(n^3)，空间复杂度O(N)
     */
    public List<List<Integer>> fore(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!result.contains(tmp)){
                            result.add(tmp);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 参考两数之和的优化思路，通过hash实现某个数的快速查找
     * 时间复杂度O(n^2)，空间复杂度O(N)
     */
    public List<List<Integer>> hash(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (set.contains(-(nums[i] + nums[j]))){
                    List<Integer> tmp = Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j]));
                    if (!result.contains(tmp)){
                        result.add(tmp);
                    }
                }
            }
        }

        return result;
    }


    /**
     * 由于最终要的是元素本身，而不是下标，因此可以使用排序。
     * 采用双指针，一个指针固定从头扫描，另外两个指针从首位扫描，根据大小进行移动，遇到一个不匹配的元素，可以将后续不匹配的全部过滤
     * 时间复杂度O(n^2)，空间复杂度O(1)
     */
    public static List<List<Integer>> twoPoint(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 双指针扫描
        int k=0;
        while (k < nums.length && nums[k] <= 0){
            if (k > 0 && nums[k] == nums[k-1]){
                // 重复解
                k++;
                continue;
            }
            int i=k+1;
            int j=nums.length-1;
            while (i < j){
                if (nums[i] + nums[j] + nums[k] == 0){
                    result.add(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                    i++;
                    while (i < j && nums[i] == nums[i-1]){
                        i++;
                    }
                    j--;
                    while (i < j && nums[j] == nums[j+1]){
                        j--;
                    }
                }else if (nums[i] + nums[j] + nums[k] < 0){
                    i++;
                    while (i < j && nums[i] == nums[i-1]){
                        i++;
                    }
                }else {
                    j--;
                    while (i < j && nums[j] == nums[j+1]){
                        j--;
                    }
                }
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        List<List<Integer>> lists = twoPoint(nums);
        System.out.println(lists);
    }


}
