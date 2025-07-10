/*
 * Leetcode 724: Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 *
 * 👉 Problem:
 * The pivot index is the index where the sum of the numbers to the left 
 * is equal to the sum of the numbers to the right.
 * Return the leftmost pivot index. If none exists, return -1.
 *
 * ✅ Approach:
 * - Create two arrays:
 *   - `prefixSum[i]`: sum of elements from 0 to i
 *   - `rightSum[i]`: sum of elements from i to end
 * - Compare prefixSum[i] and rightSum[i] at each index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * ✅ Example:
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation: Left sum = 1 + 7 + 3 = 11, Right sum = 5 + 6 = 11
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        prefixSum[0] = nums[0];
        rightSum[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }
}
