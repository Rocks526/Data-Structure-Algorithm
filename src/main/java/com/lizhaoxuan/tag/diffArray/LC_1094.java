package com.lizhaoxuan.tag.diffArray;

/**
 * 【1094】拼车
 */
public class LC_1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        // 初始化每站的人数，最多1000站
        int[] taxi = new int[1001];
        // 初始化差分数组
        Difference difference = new Difference(taxi);
        // 更新每站的上车、下车人
        for (int[] trip : trips) {
            int num = trip[0];
            int i = trip[1];
            // trip[2]站下车，trip[2]元素不占用人数
            int j = trip[2] - 1;
            difference.increment(i, j, num);
        }
        // 判断是否还有空座位
        for (int count : difference.getResult()) {
            if (count > capacity){
                return false;
            }
        }
        return true;
    }

}
