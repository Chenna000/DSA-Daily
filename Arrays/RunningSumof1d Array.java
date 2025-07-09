/*
 * Leetcode 1480: Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Given an array nums, return the running sum of nums.
 * A running sum is sum[i] = sum[i-1] + nums[i]
 *
 * Approach: Simple prefix sum using a result array.
 * Time Complexity: O(n), Space Complexity: O(n)
 */

class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }

        return res;
    }
}
