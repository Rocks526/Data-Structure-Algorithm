package com.lizhaoxuan.custom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * 自定义数组测试
 * @author lizhaoxuan
 * @date 2021/12/13
 */
@DisplayName("自定义数组测试")
public class CustomArrayTest {


    @DisplayName("空参构造方法测试")
    @Test
    public void noArgsConstructorTest(){
        CustomArray<Long> longCustomArray = new CustomArray<>();
        assertFalse(longCustomArray.getOrder(), "默认排序参数错误");
        assertEquals(0, longCustomArray.getLength(), "默认数组大小错误");
        try {
            Long aLong = longCustomArray.get(1);
            fail("数组下标越界");
        }catch (IllegalArgumentException e){
            assertEquals("Error index(1)!", e.getMessage(), "下标越界错误信息异常");
        }
    }


    @DisplayName("排序参数构造方法测试")
    @Test
    public void onlyOrderArgsConstructorTest() {
        CustomArray<Long> longCustomArray = new CustomArray<>(true);
        assertTrue(longCustomArray.getOrder(), "默认排序参数错误");
    }


    @DisplayName("全参构造方法测试")
    @Test
    public void allArgsConstructorTest(){
        CustomArray<Long> longCustomArray = new CustomArray<>(true, 20, null);
        assertTrue(longCustomArray.getOrder(), "默认排序参数错误");
        try {
            Long aLong = longCustomArray.get(1);
            fail("数组下标越界");
        }catch (IllegalArgumentException e){
            assertEquals("Error index(1)!", e.getMessage(), "下标越界错误信息异常");
        }
    }


    @DisplayName("初始化数组构造方法测试")
    @Test
    public void initArrayArgsConstructorTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomArray<Integer> longCustomArray = new CustomArray<>(true, 10, array);
        assertTrue(longCustomArray.getOrder(), "默认排序参数错误");
        assertEquals(11, longCustomArray.getLength(), "初始化数组失败");
        assertEquals(2, longCustomArray.get(1), "根据下标获取失败");
        assertEquals("CustomArray[1,2,5,3,2,9,0,6,7,4,9]", longCustomArray.toString(), "根据下标获取失败");
    }

    @DisplayName("自动扩容测试")
    @Test
    public void autoGrowTestWhenInsert(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,8};
        CustomArray<Integer> longCustomArray = new CustomArray<>(false, 10, array);
        assertTrue(longCustomArray.add(11), "插入失败");
        assertEquals(11, longCustomArray.getLength(), "数量错误");
        assertEquals("CustomArray[1,2,5,3,2,9,0,6,7,8,11]", longCustomArray.toString(), "根据下标获取失败");
    }

    @DisplayName("无序插入测试")
    @Test
    public void noOrderInsertTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomArray<Integer> longCustomArray = new CustomArray<>(false, 10, array);
        assertTrue(longCustomArray.insert(1, 10), "插入失败");
        assertEquals(12, longCustomArray.getLength(), "数量错误");
        assertEquals("CustomArray[1,10,5,3,2,9,0,6,7,4,9,2]", longCustomArray.toString(), "根据下标获取失败");
    }

    @DisplayName("有序插入测试")
    @Test
    public void orderInsertTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomArray<Integer> longCustomArray = new CustomArray<>(true, 10, array);
        assertTrue(longCustomArray.insert(1, 10), "插入失败");
        assertEquals(12, longCustomArray.getLength(), "数量错误");
        assertEquals("CustomArray[1,10,2,5,3,2,9,0,6,7,4,9]", longCustomArray.toString(), "根据下标获取失败");
    }

    @DisplayName("删除下标测试")
    @Test
    public void deleteIndexTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomArray<Integer> longCustomArray = new CustomArray<>(true, 20, array);
        Integer deleteElement = longCustomArray.deleteIndex(6);
        assertEquals(0, deleteElement, "删除元素错误");
        assertEquals(10, longCustomArray.getLength(), "数组长度错误");
    }

    @DisplayName("有序删除测试")
    @Test
    public void orderDeleteTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomArray<Integer> longCustomArray = new CustomArray<>(true, 20, array);
        Integer deleteElement = longCustomArray.deleteIndex(5);
        assertEquals("CustomArray[1,2,5,3,2,0,6,7,4,9]", longCustomArray.toString(), "删除元素导致顺序错乱");
    }

    @DisplayName("无序删除测试")
    @Test
    public void noOrderDeleteTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9};
        CustomArray<Integer> longCustomArray = new CustomArray<>(false, 20, array);
        Integer deleteElement = longCustomArray.deleteIndex(4);
        assertEquals("CustomArray[1,2,5,3,9,9,0,6,7,4]", longCustomArray.toString(), "无序删除错误");
    }

    @DisplayName("删除指定元素")
    @Test
    public void deleteTargetTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,7};
        CustomArray<Integer> longCustomArray = new CustomArray<>(true, 20, array);
        assertTrue(longCustomArray.delete(9), "删除指定元素失败");
        assertEquals("CustomArray[1,2,5,3,2,0,6,7,4,7]", longCustomArray.toString(), "删除指定元素顺序错误");
        CustomArray<Integer> longCustomArray2 = new CustomArray<>(false, 20, array);
        assertTrue(longCustomArray2.delete(9), "删除指定元素失败");
        assertEquals("CustomArray[1,2,5,3,2,7,0,6,7,4]", longCustomArray2.toString(), "删除指定元素顺序错误");
    }

    @DisplayName("删除所有指定元素")
    @Test
    public void deleteAllTargetTest(){
        Integer[] array = new Integer[]{1,2,5,3,2,9,0,6,7,4,9,8};
        CustomArray<Integer> longCustomArray = new CustomArray<>(true, 20, array);
        assertEquals(2, longCustomArray.deleteAll(9), "删除指定元素失败");
        assertEquals("CustomArray[1,2,5,3,2,0,6,7,4,8]", longCustomArray.toString(), "删除指定元素顺序错误");
        CustomArray<Integer> longCustomArray2 = new CustomArray<>(false, 20, array);
        assertEquals(2, longCustomArray2.deleteAll(9), "删除指定元素失败");
        assertEquals("CustomArray[1,2,5,3,2,8,0,6,7,4]", longCustomArray2.toString(), "删除指定元素顺序错误");
    }

}
