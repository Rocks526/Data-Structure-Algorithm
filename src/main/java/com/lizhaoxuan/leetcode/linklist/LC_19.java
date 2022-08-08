package com.lizhaoxuan.leetcode.linklist;

/**
 * LeetCode19 : 删除链表的倒数第 N 个结点
 * @author lizhaoxuan
 */
public class LC_19 {

    // 双指针，第一个指针先走N步，当第一个指针到达末尾时，第二个指针达到要删除的节点的前一个节点
    // 时间复杂度O(N)，空间复杂度O(1)，N为链表的长度
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 通过引入一个虚拟节点，避免删除头节点的情况
        ListNode visual = new ListNode(-1, head);
        ListNode quick = visual;
        ListNode slow = visual;
        for (int i = 0; i < n; i++){
            quick = quick.next;
        }
        while (quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return visual.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
