package com.lizhaoxuan.tag.prefixSum;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 【560】和为 K 的子数组
 * @author lizhaoxuan
 */
public class LC_560 {

    public int subarraySum(int[] nums, int k) {
        // 构建前缀和
        int[] prefix = new int[nums.length+1];
        prefix[0] = 0;
        for (int i=0;i<nums.length;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        // 穷举所有子数组
        int count = 0;
        for (int right=1;right<prefix.length;right++){
            for (int left=0;left<right;left++){
                if (prefix[right] - prefix[left] == k){
                    count++;
                }
            }
        }
        return count;
    }

        // 内层循环目的：计算有几个 j 能够使得 preSum[i] 和 preSum[j] 的差为 k ，j < i，即j都是i遍历过的元素，当遍历的时候，将前缀和存储起来，可以快速求出值，不需要再次遍历
    public int subarraySum_2(int[] nums, int k) {
        // 存储： 前缀和 --> 前缀和个数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 遍历，构建前缀和的同时查找个数
        int count = 0;
        int sum0_i = 0;
        for (int i=0;i<nums.length;i++){
            // 相当于之前的prefix[right]
            sum0_i += nums[i];
            // 相当于之前的prefix[left]
            int sum0_j = sum0_i - k;
            if (map.containsKey(sum0_j)){
                count += map.get(sum0_j);
            }
            map.put(sum0_i, map.getOrDefault(sum0_i, 0) + 1);
        }
        return count;
    }

}
