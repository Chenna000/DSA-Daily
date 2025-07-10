/*
 * Leetcode 1: Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Approach: HashMap to store visited elements and their indices.
 * Time Complexity: O(n), Space Complexity: O(n)
 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
