package com.lizhaoxuan.leetcode.linklist;

import java.util.HashSet;

/**
 * LeetCode142:环形链表 II
 * @author lizhaoxuan
 */
public class LC_142 {

    // 暴力解法，通过set存储，第一个重复的即环入口
    // 时间复杂度O(N)，空间复杂度O(N)，N为链表长度
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null && !visited.contains(tmp)){
            visited.add(tmp);
            tmp = tmp.next;
        }
        return tmp;
    }

    // 快慢指针
    // 快指针走f步，慢指针走s步，相遇时，f=2s，
    // 链表无环部分长度为a，环长度为b，相遇时，f比s多走n个环，则f=s+nb，s=a+nb，结合f=2s，则s=nb
    // 从head开始走a+nb可到入口节点，此时s已经走了nb，即再走a可到入口
    // 时间复杂度O(N)，空间复杂度O(1)，N为链表长度
    public ListNode detectCycle_2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle){
            // 无环
            return null;
        }
        ListNode tmp = head;
        while (tmp != slow){
            tmp = tmp.next;
            slow = slow.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        LC_142 lc_142 = new LC_142();
        ListNode listNode4 = lc_142.detectCycle_2(listNode);
        System.out.println(listNode4);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
