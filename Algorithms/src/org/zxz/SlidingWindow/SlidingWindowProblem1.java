package org.zxz.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LEGION
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，
 * 窗口每次向右边滑一个位置。窗口中每次会产生一个最大值，
 * 求这n-w+1最大值组成的数组。
 */
public class SlidingWindowProblem1 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] res = getSlidingWindowMaxArr(arr, w);
        if (res != null) {
            for (int i : res) {
                System.out.println(i);
            }
        }
    }

    private static int[] getSlidingWindowMaxArr(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - w) {
                deque.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[deque.peekFirst()];
            }
        }
        return res;
    }
}
