package com.lizhaoxuan.tag.twoPointLink;

/**
 * 链表的中间结点
 * @author lizhaoxuan
 */
public class LC_876 {

    public ListNode middleNode(ListNode head) {
        // 快慢指针，快指针两步，慢指针一步
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
