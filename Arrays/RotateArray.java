
/*
 * Leetcode 189: Rotate Array
 * Problem Link: https://leetcode.com/problems/rotate-array/
 *
 * Description:
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * ---------------------------------------------------------------
 * ✅ Approach: Reverse Array Method (In-place)
 * ---------------------------------------------------------------
 * 1. Normalize k: If k > length of array, do k = k % n.
 * 2. Reverse the entire array.
 * 3. Reverse the first k elements.
 * 4. Reverse the remaining n-k elements.
 *
 * This approach rotates the array in O(n) time and O(1) space.
 */

class Solution {

    // Helper function to reverse elements between two indices in an array
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            // Swap the elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // Normalize k in case it's greater than array length
        k = k % n;

        // Step 1: Reverse the entire array
        reverseArray(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverseArray(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverseArray(nums, k, n - 1);
    }
}
