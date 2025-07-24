/**
 * ✅ LeetCode Problem: 238. Product of Array Except Self
 * 🔗 Link: https://leetcode.com/problems/product-of-array-except-self/
 * 
 * ✅ Approach:
 * 1. Create two arrays:
 *    - `leftProd[i]`: Product of all elements to the left of `i`
 *    - `rightProd[i]`: Product of all elements to the right of `i`
 * 2. Multiply both to get the final result at each index.
 * 
 * ✅ Dry Run Example:
 * Input: [1, 2, 3, 4]
 * Left Products:  [1, 1, 2, 6]
 * Right Products: [24, 12, 4, 1]
 * Output:         [24, 12, 8, 6]
 * 
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n) – uses two auxiliary arrays
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        // Step 1: Build left product array
        leftProd[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProd[i] = nums[i - 1] * leftProd[i - 1];
        }

        // Step 2: Build right product array
        rightProd[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProd[i] = nums[i + 1] * rightProd[i + 1];
        }

        // Step 3: Multiply left and right products
        for (int i = 0; i < n; i++) {
            nums[i] = leftProd[i] * rightProd[i];
        }

        return nums;
    }
}
