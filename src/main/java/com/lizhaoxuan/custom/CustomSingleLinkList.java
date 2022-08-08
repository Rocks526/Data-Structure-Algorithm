package com.lizhaoxuan.custom;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 自定义单链表
 * @author lizhaoxuan
 */
@Slf4j
public class CustomSingleLinkList<T> implements Serializable {


    // 头指针
    private Node<T> first;
    // 尾指针
    private Node<T> last;
    // 数量
    private long count;

    public CustomSingleLinkList(){
        count = 0;
    }

    public CustomSingleLinkList(T[] data){
        for (T element : data) {
            add(element);
        }
    }

    public boolean add(T node){
        Node<T> tNode = new Node<>(node);
        if (count == 0){
            // 头节点
            last = first = tNode;
            count ++;
            return true;
        }
        last.next = tNode;
        last = tNode;
        count ++;
        return true;
    }

    public boolean remove(T node){
        if (first == null || count < 1){
            return false;
        }
        if (first.data == node){
            // 头结点
            first = first.next;
            count --;
            if (count == 0){
                // 只有一个节点
                last = null;
            }
            return true;
        }
        Node<T> tmp = first;
        while (tmp.next != null){
            if (tmp.next.data == node){
                tmp.next = tmp.next.next;
                count--;
                if (tmp.next == null){
                    // 尾结点
                    last = tmp;
                }
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public long length(){
        return count;
    }

    public boolean contain(T node){
        if (first == null || count < 1){
            return false;
        }
        Node<T> tmp = first;
        while (tmp != null){
            if (tmp.data == node){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder values = new StringBuilder();
        Node<T> tmp = first;
        while (tmp != null){
            values.append(tmp.data).append(",");
            tmp = tmp.next;
        }
        return "CustomSingleLinkList<" + values.substring(0, values.length() - 1) + ">";
    }

    /**
     * 链表节点
     */
    public static class Node<T> {

        // 数据
        private T data;
        // 后指针
        private Node<T> next;

        public Node(){
        }

        public Node(T data){
            this.data = data;
        }
        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
