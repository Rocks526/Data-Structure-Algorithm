package com.lizhaoxuan.tag.twoPointArray;

/**
 * 【167】两数之和 II
 * @author lizhaoxuan
 */
public class LC_167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                // 返回元素位数，非下标
                return new int[]{left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] < target){
                left++;
            }
            if (numbers[left] + numbers[right] > target){
                right--;
            }
        }
        return new int[]{-1, -1};
    }

}