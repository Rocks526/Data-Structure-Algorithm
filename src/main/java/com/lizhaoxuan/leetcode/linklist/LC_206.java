package com.lizhaoxuan.leetcode.linklist;

/**
 * LeetCode#206  : 翻转链表
 * @author lizhaoxuan
 */
public class LC_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
