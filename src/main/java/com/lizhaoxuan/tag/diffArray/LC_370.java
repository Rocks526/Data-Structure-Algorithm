package com.lizhaoxuan.tag.diffArray;

/**
 * 【LC-370】 区间加法
 */
public class LC_370 {

    int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);
        // 区间更新
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }
        // 获取最终结果
        return df.getResult();
    }

}
