package com.lizhaoxuan.custom;

import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;

/**
 * 自定义数组
 * @author lizhaoxuan
 */
@Slf4j
public class CustomArray <T> implements Serializable {

    // 数据
    private Object[] data;

    // 长度
    private int length;

    // 当前存储的数量
    private int count;

    // 是否要保证有序
    private boolean order;

    public CustomArray(){
        commonConstructor(false, 10, null);
    }

    public CustomArray(boolean order){
        commonConstructor(order, 10, null);
    }

    public CustomArray(boolean order, int initialCapacity, T[] initialData){
        commonConstructor(order, initialCapacity, initialData);
    }

    /**
     * 通用构造方法
     * @param order 是否保持顺序
     * @param initialCapacity  数组初始化容量
     * @param initialData  初始化数据
     */
    private void commonConstructor(boolean order, int initialCapacity, T[] initialData) {
        this.order = order;
        this.length = initialCapacity;
        this.count = 0;
        this.data = new Object[length];
        if (initialData != null && initialData.length > 0){
            for (T e : initialData){
                add(e);
            }
        }
    }

    /**
     * 判断容量是否足够，不够时自动扩容
     * @param index 要使用的下标
     */
    private void validateCapacity(int index){
        if (index > length){
            // 每次扩容两倍
            int targetCapacity = length;
            while (targetCapacity < index){
                targetCapacity *= 2;
            }
            log.debug("[CustomArray] array begin grow, current capacity = {}, target capacity = {}!", length, targetCapacity);
            Object[] target = new Object[targetCapacity];
            int i = 0;
            for (Object obj : data){
                target[i++] = obj;
            }
            data = target;
            log.debug("[CustomArray] array grow success!");
        }
    }

    private void validateIndex(int index){
        if (index < 0 || index >= count){
            // 校验下标，是否存在数据
            throw new IllegalArgumentException("Error index(" + index + ")!");
        }
    }

    public boolean add(T element){
        // 大小检查
        validateCapacity(count + 1);
        // 添加到末尾
        data[count++] = element;
        return true;
    }

    public boolean insert(int index, T element){
        // 容量校验
        validateCapacity(index);
        // 添加数据
        if (!order){
            Object oldObj = data[index];
            data[index] = element;
            data[count++] = oldObj;
            return true;
        }
        // 要求保证有序，将之后数据迁移
        for (int i=count;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        count++;
        return true;
    }

    public T deleteIndex(int index){
        // 下标校验
        validateIndex(index);
        // 获取历史数据
        T oldObj = (T) data[index];
        // 删除
        if (!order){
            data[index] = data[count-1];
            data[count-1] = null;
            count--;
            return oldObj;
        }
        for (int i=index+1;i<count;i++){
            data[i-1] = data[i];
        }
        data[count-1] = null;
        count--;
        return oldObj;
    }

    public boolean delete(T element){
        // 查找目标元素
        int index = -1;
        for (int i=0;i<count;i++){
            if (element == null && data[i] == null){
                index = i;
                break;
            }
            if (element != null && element.equals(data[i])){
                index = i;
                break;
            }
        }
        // 未找到
        if (index < 0){
            return false;
        }
        // 删除元素
        deleteIndex(index);
        return true;
    }

    public int deleteAll(T element){
        // 查找目标元素
        int[] index = new int[count];
        int j = 0;
        for (int i=0;i<count;i++){
            if (element == null && data[i] == null){
                index[j++] = i;
                continue;
            }
            if (element != null && element.equals(data[i])){
                index[j++] = i;
                continue;
            }
        }
        // 未找到
        if (j == 0){
            return 0;
        }
        // 删除元素 ==> 降序删除，先删除靠后的，否则后续index会变
        for (int i=j-1;i>=0;i--){
            deleteIndex(index[i]);
        }
        return j;
    }

    public T[] getValues(){
        return (T[]) data;
    }

    public boolean getOrder(){
        return order;
    }

    public boolean setOrder(boolean order){
        this.order = order;
        return true;
    }

    public T get(int index){
        // 下标检查
        validateIndex(index);
        // 返回数据
        return (T) data[index];
    }

    public boolean contain(T element){
        for (Object obj : data){
            if (element == null && obj == null){
                return true;
            }
            if (element != null && element.equals(obj)){
                return true;
            }
        }
        return false;
    }

    public int getLength(){
        return count;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomArray[");
        for (int i=0;i<count;i++){
            stringBuilder.append(data[i].toString()).append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1) + "]";
    }

}
