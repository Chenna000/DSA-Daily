/*
 * Leetcode 1991: Find the Middle Index in Array
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 *
 * 👉 Problem:
 * The middle index is where the sum of the numbers to the left
 * is equal to the sum of the numbers to the right.
 * Return the leftmost such index, or -1 if it doesn't exist.
 *
 * ✅ Approach:
 * - Use prefixSum[] to track sum from left
 * - Use rightSum[] to track sum from right
 * - Compare prefixSum[i] == rightSum[i] to find middle index
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * ✅ Example:
 * Input: nums = [2, 3, -1, 8, 4]
 * Output: 3
 * Explanation: Left sum = 2 + 3 + (-1) = 4, Right sum = 4
 */

class Solution {
    public int findMiddleIndex(int[] nums) {
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
