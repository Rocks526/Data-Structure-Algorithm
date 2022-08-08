package com.lizhaoxuan.tag.twoPointLink;

/**
 * 删除链表的倒数第 N 个结点
 * @author lizhaoxuan
 */
public class LC_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        // 虚拟节点，避免删除头结点导致的NPE
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 快慢指针，快指针先走N步
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
