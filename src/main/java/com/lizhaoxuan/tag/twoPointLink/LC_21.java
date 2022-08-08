package com.lizhaoxuan.tag.twoPointLink;

/**
 * 合并两个有序链表
 * @author lizhaoxuan
 */
public class LC_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        // 双指针遍历对比
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null){
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        return dummy.next;
    }

}
