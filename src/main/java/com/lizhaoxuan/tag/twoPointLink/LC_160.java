package com.lizhaoxuan.tag.twoPointLink;

/**
 * 相交链表
 * @author lizhaoxuan
 */
public class LC_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个指针分别访问两条链表，达到末尾后访问另外一条
        // 如果有相交，则下一次相等就是交点
        // 如果没有相交，则两个节点同时是NULL
        ListNode lA = headA;
        ListNode lB = headB;
        while (lA != lB){
            if (lA == null){
                lA = headB;
            }else {
                lA = lA.next;
            }
            if (lB == null){
                lB = headA;
            } else {
                lB = lB.next;
            }
        }
        return lA;
    }

}
