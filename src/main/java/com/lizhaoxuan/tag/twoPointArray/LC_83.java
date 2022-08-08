package com.lizhaoxuan.tag.twoPointArray;

/**
 * 【83】删除排序链表中的重复元素
 * @author lizhaoxuan
 */
public class LC_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        // 快慢指针
        ListNode fast = head, slow = head;
        while (fast != null){
            if (fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开后面的元素
        slow.next = null;
        return head;
    }

}