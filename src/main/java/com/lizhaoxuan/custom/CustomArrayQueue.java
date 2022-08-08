package com.lizhaoxuan.custom;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * 自定义队列
 * @author lizhaoxuan
 */
@Slf4j
public class CustomArrayQueue<T> implements Serializable {

    private T[] data;

    private int count;

    private int capacity;

    public CustomArrayQueue(){
        count = 0;
        capacity = 10;
        data = (T[]) new Object[10];
    }

    public CustomArrayQueue(int capacity, T[] elements){
        if (capacity < elements.length){
            throw new IllegalArgumentException("capacity is too small!");
        }
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        for (T element : elements) {
            push(element);
        }
    }

    public int size(){
        return count;
    }

    public int capacity(){
        return capacity;
    }

    public boolean contain(T target){
        if (target == null){
            throw new IllegalArgumentException("target is null!");
        }
        for (int i=0;i<count;i++){
            if (target.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public T peek(){
        return count > 0 ? data[count-1] : null;
    }

    public T pop(){
        if (count <= 0){
            return null;
        }
        return data[--count];
    }

    public boolean push(T value){
        if (count >= capacity - 1){
            return false;
        }
        data[count++] = value;
        return true;
    }

    public void clear(){
        for (int i=0;i<count;i++){
            data[i] = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomStack<");
        for (int i=0;i<count;i++){
            stringBuilder.append(data[i].toString()).append(",");
        }
        return (count > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1) : stringBuilder) + ">";
    }

}
