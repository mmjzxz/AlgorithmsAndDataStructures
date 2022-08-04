package org.zxz.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LEGION
 * 225 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static class MyStack<T> {
        private Queue<T> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(T param) {
            queue.add(param);
            int size = queue.size();
            while (size-- > 1) {
                queue.add(queue.poll());
            }
        }

        public T pop() {
            return queue.remove();
        }

        public T top() {
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
