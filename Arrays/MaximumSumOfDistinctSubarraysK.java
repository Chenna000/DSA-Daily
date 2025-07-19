/**
 * LeetCode Problem 2461: Maximum Sum of Distinct Subarrays With Length K
 * Link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 *
 * ✅ Approach:
 * - Use a sliding window and a HashSet to keep track of unique elements in the current window.
 * - Maintain a window of size at most 'k'.
 * - If an element is already in the window, shrink the window from the start until it's unique.
 * - Once the window size equals k, update the maximum sum.
 *
 * ✅ Time Complexity: O(n), where n = nums.length
 * ✅ Space Complexity: O(k), at most k elements in the HashSet
 *
 * 🧪 Example:
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation:
 * - Valid subarrays of length 3 with all distinct elements:
 *   [1,5,4] → 10
 *   [5,4,2] → 11
 *   [4,2,9] → 15 ✅
 */

import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        long sum = 0;
        long maxSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            while (window.contains(nums[end])) {
                window.remove(nums[start]);
                sum -= nums[start];
                start++;
            }

            window.add(nums[end]);
            sum += nums[end];

            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                // Slide the window
                window.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}
