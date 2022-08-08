package com.lizhaoxuan.custom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 自定义栈测试
 * @author lizhaoxuan
 */
@DisplayName("自定义栈测试")
public class CustomStackTest {

    @DisplayName("空参构造方法测试")
    @Test
    public void noArgsConstructorTest(){
        CustomStack<Long> stack = new CustomStack<>();
        assertEquals(0, stack.size(), "初始化长度错误");
    }

    @DisplayName("初始化数组构造方法测试")
    @Test
    public void initArrayArgsConstructorTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomStack<Integer> stack = new CustomStack<>(20, array);
        assertEquals(11, stack.size(), "初始化栈失败");
        assertTrue(stack.contain(5), "初始化栈失败");
        assertEquals("CustomStack<1,2,5,3,2,9,0,6,7,4,9>", stack.toString(), "初始化栈失败");
    }


    @DisplayName("增加元素测试")
    @Test
    public void orderInsertTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomStack<Integer> stack = new CustomStack<>(20, array);
        assertTrue(stack.push(8), "插入失败");
        assertTrue(stack.contain(8), "插入失败");
        assertEquals(12, stack.size(), "长度错误");
        assertEquals("CustomStack<1,2,5,3,2,9,0,6,7,4,9,8>", stack.toString(), "打印错误");
        assertEquals(8, stack.peek(), "栈首元素错误");
    }

    @DisplayName("弹出元素测试")
    @Test
    public void deleteTargetTest(){
        Integer[] array = new Integer[]{1};
        CustomStack<Integer> stack = new CustomStack<>(10, array);
        // 删除存在
        assertEquals(1, stack.pop(), "弹出元素失败");
        assertEquals(0, stack.size(), "长度错误");
        assertEquals("CustomStack<>", stack.toString(), "弹出元素顺序错误");
        assertNull(stack.pop(), "弹出元素失败");
    }

}
