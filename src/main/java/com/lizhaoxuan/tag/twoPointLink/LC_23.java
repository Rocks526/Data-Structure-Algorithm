package com.lizhaoxuan.tag.twoPointLink;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 * @author lizhaoxuan
 */
public class LC_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        // 最小堆，用于求所有链表最小节点
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null){
                queue.add(head);
            }
        }
        // 遍历所有链表
        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            p.next = minNode;
            ListNode next = minNode.next;
            p = p.next;
            if (next != null){
                queue.add(next);
            }
        }
        return dummy.next;
    }

}
