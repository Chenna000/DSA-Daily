/*
 * Leetcode 977: Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * 👉 Problem:
 * Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number,
 * also sorted in non-decreasing order.
 *
 * ✅ Approach 1 (Simple):
 * - Square every element
 * - Then sort the array using Arrays.sort()
 * - Time Complexity: O(n log n), Space Complexity: O(n)
 *
 * ✅ Example:
 * Input: nums = [-4, -1, 0, 3, 10]
 * Squares: [16, 1, 0, 9, 100]
 * Sorted : [0, 1, 9, 16, 100]
 */

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i]; // square each element
        }

        Arrays.sort(res); // sort the squared values
        return res;
    }
}
