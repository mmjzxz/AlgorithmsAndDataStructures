package org.zxz.stackAndQueue;

import java.util.Stack;

/**
 * @author LEGION
 * 232 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/description/
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(3);
        queue.push(2);
        queue.push(1);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }

    public static class MyQueue<T> {
        Stack<T> in = new Stack<>();
        Stack<T> out = new Stack<>();

        public void push(T param) {
            in.push(param);
        }

        public T pop() {
            inToOut();
            return out.pop();
        }

        public T peek() {
            inToOut();
            return out.peek();
        }

        public boolean isEmpty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }
}
