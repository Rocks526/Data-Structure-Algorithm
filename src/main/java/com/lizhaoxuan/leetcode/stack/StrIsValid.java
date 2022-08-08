package com.lizhaoxuan.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * LeetCode#20 : 有效的括号
 * @author lizhaoxuan
 */
public class StrIsValid {

    public boolean isValid(String s) {
        HashMap<String, String> matchMaps = new HashMap<>();
        matchMaps.put(")", "(");
        matchMaps.put("]", "[");
        matchMaps.put("}", "{");
        Stack<String> stack = new Stack<>();
        String[] chars = s.split("");
        for (String c : chars){
            if (!matchMaps.containsKey(c)){
                // 入
                stack.push(c);
                continue;
            }
            // 出
            if (stack.isEmpty() || !stack.pop().equals(matchMaps.get(c))){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
