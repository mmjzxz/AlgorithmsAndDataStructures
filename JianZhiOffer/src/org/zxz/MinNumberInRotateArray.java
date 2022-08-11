package org.zxz;

/**
 * @author LEGION
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */

public class MinNumberInRotateArray {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 5, 1, 2};
//        System.out.println(minNumberInRotateArray(arr));
        int[] arr2 = {2,2,2,1,2};
        System.out.println(minNumberInRotateArray(arr2));
    }

    private static int minNumberInRotateArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == arr[right]&&arr[mid]==arr[left]) {
                return minNumberInRotateArray(arr, left, right);
            }
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    private static int minNumberInRotateArray(int[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (arr[i] < arr[left]) {
                left = i;
            }
        }
        return arr[left];
    }
}
