/*
 * Leetcode 169: Majority Element
 * https://leetcode.com/problems/majority-element/
 *
 * 👉 Problem:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 *
 * ✅ Approach 1: Brute Force (Nested Loops)
 * - For each element, count how many times it appears
 * - If count > n/2, return that element
 * - Time Complexity: O(n^2)
 * - Space Complexity: O(1)
 *
 * ✅ Example:
 * Input: nums = [3, 2, 3]
 * Output: 3
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count;

        for (int i = 0; i < nums.length; i++) {
            count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                return nums[i];
            }
        }

        return -1; // Problem guarantees a majority element exists
    }
}
