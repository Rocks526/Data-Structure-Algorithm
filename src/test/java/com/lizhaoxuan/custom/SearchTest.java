package com.lizhaoxuan.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.lizhaoxuan.custom.Search.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二分查找算法测试
 * @author lizhaoxuan
 */
@DisplayName("二分查找算法测试")
public class SearchTest {

    private int[] array;
    private int[] array2;

    @BeforeEach
    public void init(){
        array = new int[]{0,2,4,7,9,22};
        array2 = new int[]{0,2,2,4,7,9,22};
    }

    @DisplayName("二分查找测试")
    @Test
    public void searchTest(){
        assertEquals(simpleSearch(array, 2), 1, "二分查找测试");
        assertEquals(simpleSearch(array, 22), 5, "二分查找测试");
        assertEquals(simpleSearch(array, 6), -1, "二分查找测试");
    }

    @DisplayName("查找第一个目标元素测试")
    @Test
    public void findFirstTest(){
        assertEquals(findFirst(array2, 2), 1, "二分查找测试");
        assertEquals(findFirst(array2, 22), 6, "二分查找测试");
        assertEquals(findFirst(array2, 6), -1, "二分查找测试");
    }

    @DisplayName("查找最后一个目标元素测试")
    @Test
    public void findLastTest(){
        assertEquals(findLast(array2, 2), 2, "二分查找测试");
        assertEquals(findLast(array2, 22), 6, "二分查找测试");
        assertEquals(findLast(array2, 6), -1, "二分查找测试");
    }

    @DisplayName("查找第一个大于等于目标元素测试")
    @Test
    public void findFirstGeTest(){
        assertEquals(findFirstGe(array2, 2), 1, "二分查找测试");
        assertEquals(findFirstGe(array2, 22), 6, "二分查找测试");
        assertEquals(findFirstGe(array2, 6), 4, "二分查找测试");
    }

    @DisplayName("查找最后一个小于等于目标元素测试")
    @Test
    public void findLastLeTest(){
        assertEquals(findLastLe(array2, 2), 2, "二分查找测试");
        assertEquals(findLastLe(array2, 22), 6, "二分查找测试");
        assertEquals(findLastLe(array2, 6), 3, "二分查找测试");
    }

}
