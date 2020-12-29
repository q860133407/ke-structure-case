package com.ke.case03.demo01;

/**
 * @author zxg_QAQ
 */
public class Queue<E> {

    private Object[] data = null;
    /**
     * 队列的容量
     */
    private int maxSize;
    /**
     * 队列头，允许删除
     */
    private int front;
    /**
     * 队列尾，允许插入
     */
    private int rear;
    /**
     * 构造函数，默认队列的大小为 0
     */
    public Queue() {
        this(10);
    }
    public Queue(int initialSize) {
        if (initialSize > 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0:"+initialSize);
        }
    }

    /**
     * 在队列的尾部插入数据
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满，无法插入新的元素！");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    /**
     * 删除队列头部的元素：出队
     * @return
     */
    public E poll() {
        if (data == null || data.length == 0) {
            throw new RuntimeException("空队列异常！");
        } else {
            E value = (E) data[front];
            data[front++] = null;
            return value;
        }
    }

    /**
     * 取出队列头部的元素，但不删除
     * @return
     */
    public E peek() {
        if (data == null || data.length == 0) {
            throw new RuntimeException("空队列异常！");
        } else {
            return (E) data[front];
        }
    }
}
