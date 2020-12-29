package com.ke.case02.demo01;

/**
 * 基于数组实现的顺序栈
 * @author zxg_QAQ
 */
public class Stack<E> {

    private Object[] data = null;
    /**
     * 栈容量
     */
    private int maxSize = 0;
    /**
     * 栈顶的指针
     */
    private int top = -1;

    /**
     * 构造函数：根据指定的 size 初始化栈
     */
    Stack() {
        // 默认初始化 10
        this(10);
    }

    Stack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0："+initialSize);
        }
    }

    /**
     * 进栈，第一个元素 top = 0
     * @param e
     * @return
     */
    public boolean push(E e) {
        if (top == maxSize -1) {
            throw new RuntimeException("栈已满，无法将元素入栈！");
        } else {
            data[++top] = e;
            return true;
        }
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空！");
        } else {
            return (E) data[top--];
        }
    }

    /**
     * 查找栈顶元素但不移除
     * @return
     */
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空！");
        } else {
            return (E)data[top];
        }
    }

}
