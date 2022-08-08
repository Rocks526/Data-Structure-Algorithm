package com.lizhaoxuan.tag.recursionLink;

/**
 * 【206】反转链表
 * @author lizhaoxuan
 */
public class LC_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        if (head.next == null){
            // 末尾节点，反转后也是自身
            return head;
        }
        // 反转子链表，返回子链表的首节点
        ListNode first = reverseList(head.next);
        // head.next的值是反转完成后子链表的末尾节点，将下一个节点连接到未反转的首节点上
        head.next.next = head;
        // 将首节点的next指针断掉，避免成环
        head.next = null;
        return first;
    }

    public ListNode reverseList2(ListNode head) {
        // 空指针校验
        if (head == null){
            return null;
        }
        // 遍历修改
        ListNode before = null;
        while (head.next != null){
            ListNode next = head.next;
            head.next = before;
            before = head;
            head = next;
        }
        // 修改尾节点的指向
        head.next = before;
        return head;
    }


}