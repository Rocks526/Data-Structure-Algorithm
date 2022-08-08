package com.lizhaoxuan.tag.twoPointLink;

/**
 * 环形链表 II
 * @author lizhaoxuan
 */
public class LC_142 {

    public ListNode detectCycle(ListNode head) {
        // 检测是否有环
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null){
            // 无环
            return null;
        }
        // 有环，检测环入口，让相遇之后的快慢指针随机一个放到起始位置，继续遍历，再次相遇即为环入口
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
