package org.zxz.stackAndQueue;

import java.util.Stack;

/**
 * @author LEGION
 * 20 用栈实现括号匹配
 * https://leetcode.cn/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses("()"));
        System.out.println(isValidParentheses("()[]{}"));
        System.out.println(isValidParentheses("(]"));
        System.out.println(isValidParentheses("([)]"));
        System.out.println(isValidParentheses("{[]}"));
    }

    private static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
