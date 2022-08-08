package com.lizhaoxuan.custom.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义二叉查找树
 * @author lizhaoxuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomBinarySearchTree<T> {

    private Node<T> root;



}
