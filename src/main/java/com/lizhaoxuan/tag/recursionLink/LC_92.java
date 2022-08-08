package com.lizhaoxuan.tag.recursionLink;

/**
 * 【92】 反转链表 II
 * @author lizhaoxuan
 */
public class LC_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            // 反转
            return reverseListN(head, right);
        }
        // 修改next指针，指向反转后的链表首元素
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // N节点的后驱节点
    private ListNode nodeN = null;

    // 反转前N个节点
    public ListNode reverseListN(ListNode head, int n) {
        // 终止条件
        if (n == 1){
            // 记录后驱节点
            nodeN = head.next;
            return head;
        }
        // 反转后面的链表
        ListNode first = reverseListN(head.next, n - 1);
        head.next.next = head;
        // 连接后继节点，当n == 1时，nodeN非null，即只有反转到首节点时，nodeN才有值，刚好把首节点的下一个节点连接到N节点的后驱节点
        head.next = nodeN;
        return first;
    }

    public static void main(String[] args) {
        LC_92 lc_92 = new LC_92();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode listNode = lc_92.reverseBetween(n1, 2, 4);
        listNode.print();
    }

}
