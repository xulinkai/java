package com.aggregation.alg.queue;

import java.util.Stack;

/**
 * @Desc 两个栈实现一个队列
 * @Author xlk
 * @Date 2022/3/20 下午10:26
 */
public class TwoStackImplementQueue {

    private Stack<Object> stack1;
    private Stack<Object> stack2;

    public void push(Object object) {
        stack1.push(object);
    }

    public Object poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
