package com.lizhaoxuan.custom;


/**
 * 排序算法
 * @author lizhaoxuan
 */
public class Sort {

    /**
     * 冒泡排序
     *      每次比较相邻两个元素大小，一轮比较完成后，最大/最小的元素排到末尾
     *      循环N轮后，数组实现有序
     *      优化：当某一轮比较完成后，没有交换元素，意味着已经有序了，可以不用继续遍历了。
     */
    public static void BubbleSort(int[] array){
        if (array == null || array.length == 0){
            return;
        }
        // 外层循环是轮数，N轮
        for (int i=0;i<array.length;i++){
            // 本轮是否存在交换标识
            boolean flag = false;
            // 每次都是从第一个元素开始比较，因此j从0开始，比较的末尾为数组长度减去轮数，再减1是因为要访问j+1的下标
            for (int j=0;j<array.length - i - 1;j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    /**
     * 插入排序：
     *      将数组分为有序和无序两个区间，不断从无序区间取出元素，按照顺序插入到有序区间里
     *      最开始，有序区间只有第一个元素
     */
    public static void InsertionSort(int[] array){
        if (array == null || array.length == 0){
            return;
        }
        // 外层循环是无序区间的元素遍历，从第二个元素开始
        for (int i=1;i<array.length;i++){
            // 要插入的元素
            int v = array[i];
            // 有序区间从后往前遍历，元素可以直接往后覆盖，不用存储
            int j = i -1;
            for (;j>=0;j--){
                if (array[j] > v){
                    // 大于再往后移，等于则插入后面，可以保证稳定性
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            // 插入操作需要放到子循环之外，因为插入的元素可能在0下标，永远走不进else逻辑
            array[j+1] = v;
        }
    }

    /**
     * 选择排序：
     *      选择排序和插入排序的思路一致，都是将数组分为无序区间和有序区间
     *      区别在于插入排序是从无序区间随机取值，在有序的插入有序区间，而选择排序是每次从无序区间取出最小值，放到有序区间的末尾
     */
    public static void SelectionSort(int[] array){
        if (array == null || array.length == 0){
            return;
        }
        // 外层循环，代表要插入N次
        for (int i=0;i<array.length;i++){
            int v = array[i];
            int v_index = i;
            // 内层循环，代表从无序区间里选择最小的元素
            for (int j=i;j<array.length;j++){
                if (array[j] < v){
                    v = array[j];
                    v_index = j;
                }
            }
            // 插入有序区间末尾
            array[v_index] = array[i];
            array[i] = v;
        }
    }


    /**
     * 归并排序
     *      将整个数组不断划分为子数组，将子数组排序再进行合并
     */
    public static void MergeSort(int[] array){
        if (array == null || array.length < 2){
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (right + left) / 2;
        // 左边
        mergeSort(array, left, mid);
        // 右边
        mergeSort(array, mid + 1, right);
        // 归并
        merge(array, left, mid, mid + 1, right);
    }

    private static void merge(int[] array, int left, int mid, int mid2, int right) {
        // 记录一下起始下标，用于后续将tmp复制给array
        int bak = left;
        // 合并
        int[] tmp = new int[right - left + 1];
        int index = 0;
        while (mid >= left && right >= mid2){
            if (array[mid2] < array[left]){
                tmp[index++] = array[mid2++];
            }else {
                // 相等的元素，将左侧区间的放入tmp，保证稳定性
                tmp[index++] = array[left++];
            }
        }
        while (mid >= left){
            tmp[index++] = array[left++];
        }
        while (right >= mid2){
            tmp[index++] = array[mid2++];
        }
        // 复制
        for (int v : tmp){
            array[bak++] = v;
        }
    }


    /**
     * 快速排序：不断选择分区点，将整个数组分为两个区间，将两个区间内小于分区点的元素放到左侧区间，两个区间内大于分区点的元素放到右侧区间内，即可实现有序
     */
    public static void QuickSort(int[] array){
        if (array == null || array.length < 2){
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        // 分区并将分区两侧的数据排序
        int partition = partition(array, left, right);
        // 继续排序左侧
        quickSort(array, left, partition - 1);
        // 继续排序右侧
        quickSort(array, partition + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        // 获取分区点，直接取最后一个元素
        int partition = array[right];
        // 分区 为了避免额外空间，参考插入排序的思路，将所有数组分为小于区间和大于区间，将所有大于的元素与左侧的元素进行交换
        int index = left;
        while (left <= right - 1){
            if (array[left] < partition){
                int tmp = array[left];
                array[left] = array[index];
                array[index++] = tmp;
            }
            left++;
        }
        array[right] = array[index];
        array[index] = partition;
        return index;
    }


    /**
     * 桶排序：将所有元素划分到一堆有序的桶里，将每个桶内的元素排序，再将所有桶元素归并即可。
     */
    public static void BucketSort(int[] array){
        if (array == null || array.length < 2){
            return;
        }
        // 获取元素范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int v : array){
            if (v > max){
                max = v;
            }
            if (v < min){
                min = v;
            }
        }
        // 划分桶 10个桶
        int step = (max - min) / 10;
        // 桶
        int[][] buckets = new int[10][];
        for (int i=0;i<10;i++){
            buckets[i] = new int[array.length];
        }
        // 用于记录每个桶的下标
        int[] index = new int[10];
        for (int v : array){
            // 计算要存放的桶下标
            int bucketIndex = (v - min) / step;
            if (bucketIndex >= 10){
                bucketIndex = 9;
            }
            // 更新桶元素和下标数组
            int[] bucket = buckets[bucketIndex];
            int curIndex = index[bucketIndex];
            bucket[curIndex++] = v;
            index[bucketIndex] = curIndex;
        }
        // 桶内排序
        for (int i=0;i<buckets.length;i++){
            quickSort(buckets[i], 0, index[i] - 1);
        }
        // 归并
        int j = 0;
        for (int i=0;i<buckets.length;i++){
            for (int k=0;k<index[i];k++){
                array[j++] = buckets[i][k];
            }
        }
    }

    /**
     * 计数排序：和桶排序思路一致，不过每个桶的大小都是1，可以省去桶内排序的时间开销。
     */
    public static void CountSort(int[] array){
        if (array == null || array.length < 2){
            return;
        }
        // 获取元素范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int v : array){
            if (v > max){
                max = v;
            }
            if (v < min){
                min = v;
            }
        }
        // 划分桶
        int bucketCount = max - min + 1;
        // 桶
        int[][] buckets = new int[bucketCount][];
        for (int i=0;i<bucketCount;i++){
            buckets[i] = new int[array.length];
        }
        // 用于记录每个桶的下标
        int[] index = new int[bucketCount];
        for (int v : array){
            // 计算要存放的桶下标
            int bucketIndex = v - min;
            // 更新桶元素和下标数组
            int[] bucket = buckets[bucketIndex];
            int curIndex = index[bucketIndex];
            bucket[curIndex++] = v;
            index[bucketIndex] = curIndex;
        }
        // 归并
        int j = 0;
        for (int i=0;i<buckets.length;i++){
            for (int k=0;k<index[i];k++){
                array[j++] = buckets[i][k];
            }
        }
    }

}
