package com.lizhaoxuan.leetcode.stack;

import java.util.Stack;

/**
 * LeetCode#150 : 逆波兰表达式求值
 * @author lizhaoxuan
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        // 非空校验
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        // 双栈
        Stack<Long> numStack = new Stack<>();
        // 遍历 && 入栈
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // 操作符
                Long num1 = numStack.pop();
                Long num2 = numStack.pop();
                numStack.push(calculate(num2, num1, token));
            }else {
                // 数字 ==> 入栈
                numStack.push(Long.parseLong(token));
            }
        }
        return numStack.pop().intValue();
    }

    private Long calculate(Long num1, Long num2, String operator) {
        if (operator.equals("-")){
            return num1 - num2;
        }else if (operator.equals("+")){
            return num1 + num2;
        }else if (operator.equals("*")){
            return num1 * num2;
        }else if (operator.equals("/")){
            return num1 / num2;
        }else {
            throw new IllegalArgumentException("not support operator!");
        }
    }

}
