package com.lizhaoxuan.custom.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 树节点
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Node<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;

}
