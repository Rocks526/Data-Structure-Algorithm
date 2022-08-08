package com.lizhaoxuan.tag.twoPointArray;

/**
 * 【344】反转字符串：
 * @author lizhaoxuan
 */
public class LC_344 {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right){
            // 交换字符
            char r = s[right];
            s[right--] = s[left];
            s[left++] = r;
        }
    }

}