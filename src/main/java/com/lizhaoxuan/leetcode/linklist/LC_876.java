package com.lizhaoxuan.leetcode.linklist;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

/**
 * LeetCode#876  : 链表中间节点
 * @author lizhaoxuan
 */
public class LC_876 {

    // 暴力解法，先遍历计算长度，再遍历找中间节点
    // 时间复杂度O(N)，空间复杂度O(1)
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tmp = head;
        int len = 1;
        while (tmp != null){
            tmp = tmp.next;
            len ++;
        }
        int mid = (len % 2 == 0) ? len / 2 : len / 2 + 1;
        ListNode midNode = head;
        for (int i = 1; i < mid; i++){
            midNode = midNode.next;
        }
        return midNode;
    }

    // 遍历计算长度，并存储索引和节点的映射，再计算中间节点的映射去获取
    // 时间复杂度O(N)，空间复杂度O(N)
    public ListNode middleNode_2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tmp = head;
        int len = 1;
        HashMap<Integer, ListNode> map = new HashMap<>();
        while (tmp != null){
            map.put(len, tmp);
            tmp = tmp.next;
            len++;
        }
        int mid = (len % 2 == 0) ? len / 2 : len / 2 + 1;
        return map.get(mid);
    }

    // 快慢指针
    public ListNode middleNode_3(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
