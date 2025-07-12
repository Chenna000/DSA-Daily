/*
 * Leetcode 283: Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 *
 * Approach: Use an ArrayList to collect non-zero elements and count zeroes.
 * Time Complexity: O(n), Space Complexity: O(n)
 */

import java.util.ArrayList;

class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int zeroesCount = 0;

        for (int num : nums) {
            if (num != 0) {
                temp.add(num);
            } else {
                zeroesCount++;
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }

        for (int j = temp.size(); j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
