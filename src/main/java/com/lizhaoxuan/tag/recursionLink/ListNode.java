package com.lizhaoxuan.tag.recursionLink;


public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    public void print(){
        StringBuilder r = new StringBuilder();
        ListNode t = this;
        while (t != null){
            r.append(t.val).append(" -> ");
            t = t.next;
        }
        System.out.println(r.substring(0, r.length() - 4));
    }

}
