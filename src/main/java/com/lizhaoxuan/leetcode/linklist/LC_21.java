package com.lizhaoxuan.leetcode.linklist;

/**
 * LeetCode#21  : 合并两个有序链表
 * @author lizhaoxuan
 */
public class LC_21 {

    // 双指针，顺序对比合并即可
    // 时间复杂度O(N)，空间复杂度O(1)，N为两个链表长度之和
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode visual = new ListNode(-1);
        ListNode r = visual;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                r.next = p2;
                p2 = p2.next;
            }else {
                r.next = p1;
                p1 = p1.next;
            }
            r = r.next;
        }
        while (p1 != null){
            r.next = p1;
            r = r.next;
            p1 = p1.next;
        }
        while (p2 != null){
            r.next = p2;
            r = r.next;
            p2 = p2.next;
        }
        return visual.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
