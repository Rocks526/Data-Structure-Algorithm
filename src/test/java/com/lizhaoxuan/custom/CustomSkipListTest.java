package com.lizhaoxuan.custom;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 自定义跳表测试
 * @author lizhaoxuan
 */
@DisplayName("自定义跳表测试")
public class CustomSkipListTest {

    @DisplayName("新增元素测试")
    @Test
    public void insertTest(){
        CustomSkipList customSkipList = new CustomSkipList();
        customSkipList.insert(3);
        customSkipList.insert(1);
        customSkipList.insert(8);
        customSkipList.insert(2);
        customSkipList.insert(0);
        customSkipList.insert(4);
        customSkipList.insert(7);
        customSkipList.insert(11);
        customSkipList.insert(6);
        customSkipList.printAll_beautiful();
        assertEquals("0,1,2,3,4,6,7,8,11", customSkipList.printAll(), "跳表新增异常");
    }

    @DisplayName("删除元素测试")
    @Test
    public void deleteTest(){
        // 构建跳表
        CustomSkipList customSkipList = new CustomSkipList();
        customSkipList.insert(3);
        customSkipList.insert(1);
        customSkipList.insert(8);
        customSkipList.insert(2);
        customSkipList.insert(0);
        customSkipList.insert(4);
        customSkipList.insert(7);
        customSkipList.insert(11);
        customSkipList.insert(6);
        customSkipList.printAll_beautiful();
        assertEquals("0,1,2,3,4,6,7,8,11", customSkipList.printAll(), "跳表新增异常");
        // 删除不存在元素测试
        boolean delete = customSkipList.delete(33);
        assertFalse(delete);
        // 删除存在的元素测试
        boolean delete1 = customSkipList.delete(8);
        assertTrue(delete1);
        assertEquals("0,1,2,3,4,6,7,11", customSkipList.printAll(), "跳表新增异常");
        customSkipList.printAll_beautiful();
    }

    @DisplayName("查询测试")
    @Test
    public void findTest(){
        // 构造基础数据
        HashSet<Integer> set = new HashSet<>(10000);
        int startValue = 0;
        for (int i = 0; i < 10000; i++){
            startValue += RandomUtils.nextInt(1, 10);
            set.add(startValue);
        }
        // 构造跳表
        CustomSkipList customSkipList = new CustomSkipList();
        set.forEach(v -> {
            long l = System.currentTimeMillis();
            customSkipList.insert(v);
//            System.out.println("[Insert] ==> [" + v + "] Custom time [" + (System.currentTimeMillis() - l) + "]ms!");
        });
        // 查询元素
        set.forEach(v -> {
            long l = System.currentTimeMillis();
            CustomSkipList.Node node = customSkipList.find(v);
//            System.out.println("[Find] ==> [" + node + "] Custom time [" + (System.currentTimeMillis() - l) + "]ms!");
            assertNotNull(node, v + " 元素未查找到");
        });
        // 打印跳表结构
        customSkipList.printAll_beautiful();
    }

}
