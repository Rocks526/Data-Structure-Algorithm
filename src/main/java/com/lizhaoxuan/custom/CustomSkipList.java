package com.lizhaoxuan.custom;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 自定义跳表实现，只支持int类型，不支持重复数据
 * @author lizhaoxuan
 */
public class CustomSkipList {

    // 最高多少层索引
    private static final int MAX_LEVEL = 16;
    // 当前索引层数
    private int levelCount = 1;

    // 头节点
    private Node head = new Node();

    private Random random = new Random();

    public Node find(int value){
        Node tmp = head;
        // 从顶层索引开始查找
        for (int i = levelCount - 1; i >= 0; i--){
            // 同一层索引，继续往后搜索
            while (tmp.forwards[i] != null && tmp.forwards[i].data < value){
                tmp = tmp.forwards[i];
            }
        }
        // 此时已经到达第一层数据层，并且当前节点小于value，下一个节点就大于或等于value，因此判断下一个节点即可
        if (tmp.forwards[0] != null && tmp.forwards[0].data == value){
            return tmp.forwards[0];
        }
        return null;
    }

    public void insert(int value){
        // 获取随机层数 第一次插入只能拿一层
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 优化一下 ==> 每次最多层高加一层，避免第一个节点添加的时候，就加入了多层
        if (level > levelCount){
            level = ++levelCount;
        }
        // 查询每层要插入的前驱节点 ==> 要更新前驱节点的forwards数组，并插入新的节点
        Node[] beforeNodes = new Node[level];
        Node tmp = head;
        for (int i = level - 1; i >= 0; i--){
            while (tmp.forwards[i] != null && tmp.forwards[i].data < value){
                // 查找每一层，要插入目标节点的前驱节点
                tmp = tmp.forwards[i];
            }
            // 找到i层的前驱节点，记录起来
            beforeNodes[i] = tmp;
        }
        // 插入新的元素，并更新前驱节点的forwards数组
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        for (int i = 0;i < level; i ++){
            // 记录当前层节点后面节点指针
            newNode.forwards[i] = beforeNodes[i].forwards[i];
            // 前一个节点的指针，指向当前节点
            beforeNodes[i].forwards[i] = newNode;
        }
        // 更新层高
        if (levelCount < level) levelCount = level;
    }

    public boolean delete(int value){
        // 查找每一层目标节点的前驱节点
        Node[] beforeNodes = new Node[levelCount];
        Node tmp = head;
        for (int i = levelCount - 1; i >= 0; i--){
            while (tmp.forwards[i] != null && tmp.forwards[i].data < value){
                tmp = tmp.forwards[i];
            }
            beforeNodes[i] = tmp;
        }

        // 此时，tmp是第一层的小于value的元素，判断下一个元素是否等于value，如果不等于，则删除的元素不存在，反之存在，存在则逐层删除
        if (tmp.forwards[0] != null && tmp.forwards[0].data == value){
            for (int i = levelCount - 1; i >= 0;i--){
                if (beforeNodes[i].forwards[i] != null && beforeNodes[i].forwards[i].data == value){
                    // 此层存在目标元素，进行删除
                    beforeNodes[i].forwards[i] = beforeNodes[i].forwards[i].forwards[i];
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 插入数据时，生成随机层数，用于确定该数据往哪些层索引插入
     *   // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     *   // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     *   // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     *   //        50%的概率返回 1
     *   //        25%的概率返回 2
     *   //      12.5%的概率返回 3 ...
     */
    private int randomLevel(){
        int level = 1;
        while (random.nextInt() % 2 == 1 && level < MAX_LEVEL){
            level++;
        }
        return level;
    }

    /**
     * 打印每个节点数据和最大层数
     */
    public String printAll() {
        StringBuilder str = new StringBuilder();
        Node p = head;
        while (p.forwards[0] != null) {
            str.append(p.forwards[0].data).append(",");
            p = p.forwards[0];
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : "";
    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        // 第一列节点
        Node[] c = p.forwards;
        // tmp用于遍历操作
        Node[] tmp = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            StringBuilder levelStr = new StringBuilder();
            levelStr.append("[Level-").append(i+1).append("] : ");
            boolean hasNode = false;
            while (tmp[i] != null){
                hasNode = true;
                levelStr.append(tmp[i].data).append(" -> ");
                // 注意，要更新tmp整体数组，而不能更新里面的元素引用
//                tmp[i] = tmp[i].forwards[i];
                tmp = tmp[i].forwards;
            }
            System.out.println(hasNode ? levelStr.substring(0, levelStr.length() - 3) : levelStr);
            // 恢复tmp为第一列节点，继续遍历下一层
            tmp = c;
        }
    }

    public class Node {
        // 节点的值
        private int data = -1;
        // 下一个节点的所有层的数据，例如forwards[3]代表当前节点的下个节点的第三层索引数据
        private Node forwards[] = new Node[MAX_LEVEL];
        // 下个节点，最大在哪一层索引有值
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

}
