package com.lizhaoxuan.custom;

/**
 * 二分查找
 * @author lizhaoxuan
 */
public class Search {

    /**
     * 无重复元素的数组里二分查找
     */
    public static int simpleSearch(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (right + left) / 2;
            if (array[mid] == target){
                return mid;
            }else if (array[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值得元素
     */
    public static int findFirst(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (array[mid] > target){
                right = mid - 1;
            }else if (array[mid] < target){
                left = mid + 1;
            }else {
                // 判断是否是第一个元素
                if (mid == 0 || array[mid-1] != target){
                    return mid;
                }else {
                    // 前面还有相等的元素
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值得元素
     */
    public static int findLast(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (array[mid] > target){
                right = mid - 1;
            }else if (array[mid] < target){
                left = mid + 1;
            }else {
                // 判断是否是最后一个元素
                if (mid == array.length - 1 || array[mid+1] != target){
                    return mid;
                }else {
                    // 后面还有小于等于的元素
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个值大于等于给定值得元素
     */
    public static int findFirstGe(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (array[mid] >= target){
                // 判断是否是第一个元素
                if (mid == 0 || array[mid-1] < target){
                    return mid;
                }else {
                    // 前面还有大于等于的元素
                    right = mid - 1;
                }
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值小于等于给定值得元素
     */
    public static int findLastLe(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (array[mid] <= target){
                // 判断是否是最后一个元素
                if (mid == array.length - 1 || array[mid+1] > target){
                    return mid;
                }else {
                    // 后面还有小于等于的元素
                    left = mid + 1;
                }
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
