package com.lizhaoxuan.leetcode.recursion;

import java.util.HashMap;

/**
 * LeetCode#70 : 爬楼梯
 * @author lizhaoxuan
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 1){
            throw new IllegalArgumentException("N must greater than zero!");
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private HashMap<Integer, Integer> result = new HashMap<>();

    /**
     * 缓存一下计算结果，避免重复计算
     */
    public int climbStairs_2(int n) {
        if (n < 1){
            throw new IllegalArgumentException("N must greater than zero!");
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (result.containsKey(n)){
            return result.get(n);
        }
        int v = climbStairs(n - 1) + climbStairs(n - 2);
        result.put(n, v);
        return v;
    }

    /**
     * 递归改for循环
     * @param n
     * @return
     */
    public int climbStairs_3(int n) {
        if (n < 1){
            throw new IllegalArgumentException("N must greater than zero!");
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        // 最终值
        int v = 0;
        // 子问题的解, f(n-1) f(n-2)
        int pre = 2;
        int pre2 = 1;
        for (int i=3;i<=n;i++){
            // 递推公式
            v = pre + pre2;
            pre2 = pre;
            pre = v;
        }
        return v;
    }

}
