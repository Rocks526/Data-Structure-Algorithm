package com.lizhaoxuan.leetcode.stack;

import java.util.Stack;

/**
 * LeetCode#232 : 用栈实现队列
 * @author lizhaoxuan
 */
public class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

}
