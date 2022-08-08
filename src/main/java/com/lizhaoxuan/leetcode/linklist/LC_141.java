package com.lizhaoxuan.leetcode.linklist;

import java.util.HashSet;
import java.util.concurrent.*;

/**
 * LeetCode#141  : 环形链表
 * @author lizhaoxuan
 */
public class LC_141 {

    // 快慢指针
    // 时间复杂度O(N)，空间复杂度O(1)，N为链表长度
    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick){
                return true;
            }
        }
        return false;
    }

    // 暴力遍历
    // 时间复杂度固定时间，空间复杂度O(1)
    public boolean hasCycle_2(ListNode head) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Boolean> future = executorService.submit(() -> {
            ListNode tmp = head;
            while (tmp != null){
                tmp = tmp.next;
                if (Thread.interrupted()){
                    return true;
                }
            }
            return false;
        });
        try {
            return future.get(500, TimeUnit.MICROSECONDS);
        } catch (Exception e) {
            return true;
        }finally {
            future.cancel(true);
            executorService.shutdown();
        }
    }

    // 通过set保存所有遍历的冤死进行判重
    // 时间复杂度O(N)，空间复杂度O(N)，N为链表长度
    public boolean hasCycle_3(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null && !visited.contains(tmp)){
            visited.add(tmp);
            tmp = tmp.next;
        }
        return tmp != null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
