package com.lizhaoxuan.leetcode.linklist;

/**
 * LeetCode25:K 个一组翻转链表
 * @author lizhaoxuan
 */
public class LC_25 {

    // 双指针，一个指针用于翻转链表，一个指针用于探测是否还有下一轮
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2){
            return head;
        }
        ListNode detect = head;
        ListNode res = null;
        ListNode tmp = head;
        ListNode prev = null;
        ListNode first = null;
        while (true){
            for (int i = 0; i < k; i++){
                detect = detect == null ? null : detect.next;
            }
            if (detect == null){
                break;
            }
            // 还存在下一轮翻转
            first = tmp;
            for (int i = 0; i < k; i++){
                ListNode next = tmp.next;
                tmp.next = prev;
                prev = tmp;
                tmp = next;
            }
            if (res == null){
                res = prev;
            }
            first.next = tmp;
            prev = first;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
