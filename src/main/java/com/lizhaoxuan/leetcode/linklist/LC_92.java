package com.lizhaoxuan.leetcode.linklist;

/**
 * LeetCode92:反转链表 II
 */
public class LC_92 {

    // 注意空链表、单个节点、left=right、从头反转、从尾反转等边界条件
    // 时间复杂度O(N)，空间复杂度O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left > right || left == right){
            return head;
        }
        ListNode visual = new ListNode(-1, head);
        ListNode tmp = visual;
        ListNode prev = null;
        int index = 0;
        ListNode beforeStartNode = null;
        ListNode startNode = null;
        while (tmp != null){
            // 记录开始反转的前一个节点
            if (index == left - 1){
                beforeStartNode = tmp;
            }
            // 记录反转开始的节点
            if (index == left){
                startNode = tmp;
            }
            // 反转结束
            if (index == right){
                beforeStartNode.next = tmp;
                startNode.next = tmp.next;
                tmp.next = prev;
                break;
            }
            // 反转
            if (index >= left && index < right){
                ListNode next = tmp.next;
                tmp.next = prev;
                prev = tmp;
                tmp = next;
            }else {
                prev = tmp;
                tmp = tmp.next;
            }
            index++;
        }
        return visual.next;
    }


    public static void main(String[] args) {
        LC_92 lc_92 = new LC_92();
//        ListNode listNode = new ListNode(5);
//        ListNode listNode1 = new ListNode(4, listNode);
//        ListNode listNode2 = new ListNode(3, listNode1);
//        ListNode listNode3 = new ListNode(2, listNode2);
//        ListNode listNode4 = new ListNode(1, listNode3);
//        ListNode listNode5 = lc_92.reverseBetween(listNode4, 2, 4);

        ListNode listNode = new ListNode(5);
        ListNode listNode5 = lc_92.reverseBetween(listNode, 1, 1);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
