package com.lizhaoxuan.leetcode.linklist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * LeetCode#23  : 合并K个有序链表
 * @author lizhaoxuan
 */
public class LC_23 {

    // K个有序链表，两两合并
    // 时间复杂度O(KN)，空间复杂度O(1)，K为链表的个数，N为每次合并后的链表长度
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode prevResult = lists[0];
        for (int i = 1;i < lists.length; i++){
            prevResult = mergeTwoLists(prevResult, lists[i]);
        }
        return prevResult;
    }

    // 多指针扫描
    // 时间复杂度O(KN)，空间复杂度O(1)，K为链表的个数，N为每次合并后的链表长度
    public ListNode mergeKLists_2(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode visual = new ListNode(-1);
        ListNode r = visual;
        while (true){
            // 遍历所有链表的头节点，检查最小节点
            ListNode minNode = null;
            int minNodeIndex = -1;
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++){
                if (Objects.nonNull(lists[i]) && lists[i].val < minVal){
                    minNode = lists[i];
                    minNodeIndex = i;
                    minVal = lists[i].val;
                }
            }
            // 检查是否还有节点
            if (Objects.isNull(minNode)){
                break;
            }
            // 更新链表
            r.next = minNode;
            r = r.next;
            lists[minNodeIndex] = lists[minNodeIndex].next;
        }
        return visual.next;
    }

    // 优化多个链表里查找最小节点的地方，通过小顶堆实现O(logN)快速查找
    // 时间复杂度O(NLogK)，空间复杂度O(K)，K为链表的个数，N为每次合并后的链表长度
    public ListNode mergeKLists_3(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode visual = new ListNode(-1);
        ListNode r = visual;
        // 初始化队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(o -> o.val));
        Arrays.stream(lists).filter(Objects::nonNull).forEach(queue::add);
        while (!queue.isEmpty()){
            r.next = queue.poll();
            r = r.next;
            if (Objects.nonNull(r.next)){
                queue.add(r.next);
            }
        }
        return visual.next;
    }


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
