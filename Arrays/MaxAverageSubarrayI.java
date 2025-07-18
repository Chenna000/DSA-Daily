/**
 * LeetCode Problem 643: Maximum Average Subarray I
 * Problem Link: https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * Approach:
 * - Use Sliding Window technique of size `k`.
 * - Calculate initial window sum for first `k` elements.
 * - Slide the window across the array by subtracting the element that moves out and adding the new element that comes in.
 * - Keep track of the maximum sum seen during sliding.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Example:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75 (subarray [12,-5,-6,50] has the max average)
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        // Calculate initial window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }
}
