package com.lizhaoxuan.custom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 自定义单链表测试
 * 2022/02/04
 */
@DisplayName("自定义单链表测试")
public class CustomSingleLinkListTest {

    @DisplayName("空参构造方法测试")
    @Test
    public void noArgsConstructorTest(){
        CustomSingleLinkList<Long> longCustomSingleLinkList = new CustomSingleLinkList<>();
        assertEquals(0, longCustomSingleLinkList.length(), "初始化长度错误");
    }

    @DisplayName("初始化数组构造方法测试")
    @Test
    public void initArrayArgsConstructorTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomSingleLinkList<Integer> linkList = new CustomSingleLinkList<>(array);
        assertEquals(11, linkList.length(), "初始化数组失败");
        assertTrue(linkList.contain(5), "初始化数组失败");
        assertEquals("CustomSingleLinkList<1,2,5,3,2,9,0,6,7,4,9>", linkList.toString(), "初始化数组失败");
    }


    @DisplayName("新增测试")
    @Test
    public void orderInsertTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomSingleLinkList<Integer> linkList = new CustomSingleLinkList<>(array);
        assertTrue(linkList.add(8), "插入失败");
        assertTrue(linkList.contain(8), "插入失败");
        assertEquals(12, linkList.length(), "长度错误");
        assertEquals("CustomSingleLinkList<1,2,5,3,2,9,0,6,7,4,9,8>", linkList.toString(), "打印错误");
    }

    @DisplayName("删除指定元素")
    @Test
    public void deleteTargetTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,7};
        CustomSingleLinkList<Integer> linkList = new CustomSingleLinkList<>(array);
        // 删除存在
        assertTrue(linkList.remove(9), "删除指定元素失败");
        assertEquals(10, linkList.length(), "长度错误");
        assertEquals("CustomSingleLinkList<1,2,5,3,2,0,6,7,4,7>", linkList.toString(), "删除指定元素顺序错误");
        // 删除不存在
        assertFalse(linkList.remove(33), "删除指定元素失败");
        assertEquals(10, linkList.length(), "长度错误");
        assertEquals("CustomSingleLinkList<1,2,5,3,2,0,6,7,4,7>", linkList.toString(), "删除指定元素顺序错误");
    }

}
