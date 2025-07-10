/*
 * Leetcode 26: Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * 👉 Problem:
 * Given a sorted array nums, remove the duplicates in-place such that each unique element appears only once.
 * Return the number of unique elements (do not use extra space for another array).
 *
 * ✅ Approach (Two Pointers):
 * - Use two pointers: `i` (points to last unique element) and `j` (scans the array).
 * - Start from j = 1 and compare nums[j] with nums[i].
 * - If they are different, it means nums[j] is a new unique element.
 *   Move `i` forward and assign nums[i] = nums[j].
 * - At the end, return i + 1 which represents the count of unique elements.
 *
 * 🔸 Time Complexity: O(n)
 * 🔸 Space Complexity: O(1)
 *
 * ✅ Example:
 * Input:  nums = [1, 1, 2, 2, 3]
 * Step-by-step:
 * i = 0
 * j = 1 → nums[1] == nums[0] → duplicate → skip
 * j = 2 → nums[2] != nums[0] → i = 1 → nums[1] = nums[2] → [1, 2, 2, 2, 3]
 * j = 3 → nums[3] == nums[1] → duplicate → skip
 * j = 4 → nums[4] != nums[1] → i = 2 → nums[2] = nums[4] → [1, 2, 3, 2, 3]
 * Return i + 1 = 3
 *
 * Output: 3, and the first 3 elements are [1, 2, 3]
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // Pointer for the last unique element

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j]; // Move unique element forward
            }
        }

        return i + 1; // Count of unique elements
    }
}
