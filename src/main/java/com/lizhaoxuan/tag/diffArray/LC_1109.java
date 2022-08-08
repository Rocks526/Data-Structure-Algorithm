package com.lizhaoxuan.tag.diffArray;

/**
 * 【1109】航班预定统计
 */
public class LC_1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 输出化航班
        int[] answer = new int[n];
        // 初始化差分数组
        Difference difference = new Difference(answer);
        // 更新航班记录
        for (int[] update : bookings){
            // 航班从1开始，数组从0开始，需要减1
            difference.increment(update[0]-1, update[1]-1, update[2]);
        }
        return difference.getResult();
    }

}
