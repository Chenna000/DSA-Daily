/**
 * LeetCode Problem 1732: Find the Highest Altitude
 * Link: https://leetcode.com/problems/find-the-highest-altitude/
 *
 * ✅ Brute Force Approach [Commented]
 * - Construct prefix sum array with one extra space.
 * - Fill each altitude from previous altitude + gain[i]
 * - Sort the prefix array to get max altitude.
 * 
 * Time Complexity: O(n log n) — due to sorting
 * Space Complexity: O(n) — for prefix array
 *
 * ✅ Optimal Approach
 * - Iterate through gain array, maintaining a running sum and track max.
 * - No need to store entire prefix array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * 🧪 Example:
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation:
 * - Altitudes: [0, -5, -4, 1, 1, -6]
 * - Highest is 1
 */

class Solution {
    public int largestAltitude(int[] gain) {

        // Brute Force Approach
        // int [] prefixSum = new int[gain.length + 1];
        // prefixSum[0] = 0;
        // prefixSum[1] = gain[0];
        // int maxSum = 0;
        // int idx = 2;
        // for (int i = 1; i < gain.length; i++) {
        //     prefixSum[idx++] = prefixSum[i] + gain[i];
        // }
        // Arrays.sort(prefixSum);
        // return prefixSum[prefixSum.length - 1];

        // ✅ Optimal Approach
        int curAlt = 0;
        int maxAlt = 0;

        for (int i = 0; i < gain.length; i++) {
            curAlt += gain[i];
            if (curAlt > maxAlt) {
                maxAlt = curAlt;
            }
        }
        return maxAlt;
    }
}
