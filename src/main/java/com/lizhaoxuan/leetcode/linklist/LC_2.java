package com.lizhaoxuan.leetcode.linklist;

/**
 * LeetCode2 : 两数相加
 * @author lizhaoxuan
 */
public class LC_2 {

    // 双指针
    // 时间复杂度O(N)，空间复杂度O(1)，N为两个链表里较长的那一个链表的长度
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode visual = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode r = visual;
        // 下一位的进位数
        int grow = 0;
        while (p1 != null || p2 != null || grow > 0){
            int sum = 0;
            if (p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            sum += grow;
            int cur = sum % 10;
            grow = sum / 10;
            r.next = new ListNode(cur);
            r = r.next;
        }
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
