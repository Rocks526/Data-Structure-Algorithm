package com.lizhaoxuan.custom.tree;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 树操作工具包
 * @author lizhaoxuan
 */
public class TreeUtils {

    /**
     * 先序遍历
     */
    public static String preOrder(Node<?> root){
        StringBuilder result = new StringBuilder();
        result.append("Tree<");
        preOrderInner(root, result);
        String substring = result.substring(0, result.length() - 1);
        return substring + ">";
    }

    private static void preOrderInner(Node<?> root, StringBuilder result) {
        if (root == null){
            return;
        }
        result.append(root.getValue()).append(",");
        preOrderInner(root.getLeft(), result);
        preOrderInner(root.getRight(), result);
    }

    /**
     * 中序遍历
     */
    public static String inOrder(Node<?> root){
        StringBuilder result = new StringBuilder();
        result.append("Tree<");
        inOrderInner(root, result);
        String substring = result.substring(0, result.length() - 1);
        return substring + ">";
    }

    private static void inOrderInner(Node<?> root, StringBuilder result) {
        if (root == null){
            return;
        }
        inOrderInner(root.getLeft(), result);
        result.append(root.getValue()).append(",");
        inOrderInner(root.getRight(), result);
    }

    /**
     * 后序遍历
     */
    public static String postOrder(Node<?> root){
        StringBuilder result = new StringBuilder();
        result.append("Tree<");
        postOrderInner(root, result);
        String substring = result.substring(0, result.length() - 1);
        return substring + ">";
    }

    private static void postOrderInner(Node<?> root, StringBuilder result) {
        if (root == null){
            return;
        }
        postOrderInner(root.getLeft(), result);
        postOrderInner(root.getRight(), result);
        result.append(root.getValue()).append(",");
    }

    /**
     * 层次遍历
     */
    public static String levelOrder(Node<?> root){
        StringBuilder result = new StringBuilder();
        result.append("Tree<");
        ArrayBlockingQueue<Node<?>> queue = new ArrayBlockingQueue<>(Integer.MAX_VALUE);
        queue.add(root);
        while (!queue.isEmpty()){
            Node<?> node = queue.poll();
            result.append(node.getValue()).append(",");
            if (node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if (node.getRight() != null){
                queue.add(node.getRight());
            }
        }
        String substring = result.substring(0, result.length() - 1);
        return substring + ">";
    }

}
