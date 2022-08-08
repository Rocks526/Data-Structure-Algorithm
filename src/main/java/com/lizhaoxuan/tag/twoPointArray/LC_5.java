package com.lizhaoxuan.tag.twoPointArray;

/**
 * 【5】 最长回文子串
 * @author lizhaoxuan
 */
public class LC_5 {

    public String longestPalindrome(String s) {
        String res = "";
        // 尝试以每个元素为中心，计算最长回文串
        for (int i=0;i<s.length();i++){
            // 查找奇数结果
            String palindrome = palindrome(s, i, i);
            res = palindrome.length() > res.length() ? palindrome : res;
            // 查找偶数结果
            String palindrome1 = palindrome(s, i, i + 1);
            res = palindrome1.length() > res.length() ? palindrome1 : res;
        }
        return res;
    }

    // 在字符串s中寻找以left和right为中心的回文串
    public String palindrome(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // substring默认左闭右开，left+1后就是左右都开
        return s.substring(left+1, right);
    }

}