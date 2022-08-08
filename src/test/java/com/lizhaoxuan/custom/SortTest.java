package com.lizhaoxuan.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.lizhaoxuan.custom.Sort.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 排序算法测试
 * @author lizhaoxuan
 */
@DisplayName("排序算法测试")
public class SortTest {

    private int[] array;

    private final String arraySortString = "[0, 2, 4, 7, 9, 22]";

    @BeforeEach
    public void init(){
        array = new int[]{2,0,9,22,7,4};
    }

    @DisplayName("冒泡排序")
    @Test
    public void BubbleSortTest(){
        BubbleSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "冒泡排序错误");
    }

    @DisplayName("插入排序")
    @Test
    public void InsertionSortTest(){
        InsertionSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "插入排序错误");
    }

    @DisplayName("选择排序")
    @Test
    public void SelectionSortTest(){
        SelectionSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "选择排序错误");
    }

    @DisplayName("归并排序")
    @Test
    public void MergeSortTest(){
        MergeSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "归并排序错误");
    }

    @DisplayName("快速插入排序")
    @Test
    public void QuickSortTest(){
        QuickSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "快速排序错误");
    }

    @DisplayName("桶排序")
    @Test
    public void BucketSortTest(){
        BucketSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "桶排序错误");
    }

    @DisplayName("计数排序")
    @Test
    public void CountSortTest(){
        CountSort(array);
        assertEquals(arraySortString, Arrays.toString(array), "计数排序错误");
    }

}
