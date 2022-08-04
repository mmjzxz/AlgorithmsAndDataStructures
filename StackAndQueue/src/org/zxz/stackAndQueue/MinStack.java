package org.zxz.stackAndQueue;

import java.util.Stack;

/**
 * @author LEGION
 * 155 最小值栈
 * https://leetcode.cn/problems/min-stack/description/
 */
public class MinStack {
    public static void main(String[] args) {
        MinStackImpl minStack = new MinStackImpl();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
    }

    public static class MinStackImpl {
        private Stack stack;
        private Stack minStack;
        private int min;

        public MinStackImpl() {
            stack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x <= min) {
                minStack.push(x);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : (int) minStack.peek();
        }

        public int top() {
            return (int) stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
