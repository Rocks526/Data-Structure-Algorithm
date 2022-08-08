package com.lizhaoxuan.leetcode.search;

/**
 * LeetCode # 69 : x的平方根
 * @author lizhaoxuan
 */
public class BinarySearch {

    /**
     * 二分查找，下界为0，上界为x
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int target = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if ((long) mid * mid < x){
                left = mid + 1;
                target = mid;
            }else if ( (long) mid * mid > x){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.mySqrt(2147395599);
        System.out.println(i);
    }

}
