package com.lizhaoxuan.leetcode.linklist;

import java.util.HashSet;

/**
 * LeetCode160:相交链表
 * @author lizhaoxuan
 */
public class LC_160 {

    // set去重
    // 时间复杂度O(N)，空间复杂度O(N)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        HashSet<ListNode> visited = new HashSet<>();
        while (p1 != null || p2 != null){
            if (p1 != null){
                if (visited.contains(p1)){
                    return p1;
                }
                visited.add(p1);
                p1 = p1.next;
            }
            if (p2 != null){
                if (visited.contains(p2)){
                    return p2;
                }
                visited.add(p2);
                p2 = p2.next;
            }
        }
        return null;
    }

    // 双指针，从两个链表头部开始遍历，当一个链表遍历完后，从另一个头部开始继续
    // 如果相交，最终两个节点都走了一遍交点后的长度和两个链表交点之前长度之和
    // 如果不相交，会有一个链表走到null
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        // 是否重置过
        boolean resetA = false;
        boolean resetB = false;
        while (true){
            if (p1 == null){
                if (resetA){
                    return null;
                }
                p1 = headB;
                resetA = true;
            }
            if (p2 == null){
                if (resetB){
                    return null;
                }
                p2 = headA;
                resetB = true;
            }
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }

        public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
