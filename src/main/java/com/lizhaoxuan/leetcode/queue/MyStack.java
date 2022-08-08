package com.lizhaoxuan.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode#225 : 用队列实现栈
 * @author lizhaoxuan
 */
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        // 每一刻都有一个队列为空，将新元素入队，再将之前的元素倒出来重新入队
        if (queue1.isEmpty()){
            queue1.offer(x);
            while (!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
        }else {
            queue2.offer(x);
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
        }
    }

    public int pop() {
        if (!queue1.isEmpty()){
            return queue1.poll();
        }
        if (!queue2.isEmpty()){
            return queue2.poll();
        }
        return -1;
    }

    public int top() {
        if (!queue1.isEmpty()){
            return queue1.peek();
        }
        if (!queue2.isEmpty()){
            return queue2.peek();
        }
        return -1;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
