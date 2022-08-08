package com.lizhaoxuan.tag.twoPointLink;

/**
 * 环形链表
 * @author lizhaoxuan
 */
public class LC_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        // 快慢指针，如果有环，慢指针早晚追上快指针
        ListNode slow = head.next , fast = head.next.next;
        while (fast != null && fast.next != null && slow != fast){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow == fast;
    }

}
