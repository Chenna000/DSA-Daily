/**
 * LeetCode Problem 1343: Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * Link: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 *
 * ✅ Approach:
 * - Use a sliding window of size k.
 * - Maintain a running sum and compare average of current window with threshold.
 * - Update count when condition satisfies.
 *
 * 🧪 Example:
 * Input: arr = [2,1,3,4,1,2,1,5,3], k = 3, threshold = 4
 * Output: 2
 * Explanation:
 * Subarrays of size 3:
 * [2,1,3] → avg=2.0
 * [1,3,4] → avg=2.66
 * [3,4,1] → avg=2.66
 * [4,1,2] → avg=2.33
 * [1,2,1] → avg=1.33
 * [2,1,5] → avg=2.66
 * [1,5,3] → avg=3.0
 * Only 2 subarrays have average >= 4 → Output: 2
 *
 * ⏱️ Time Complexity: O(n)
 * 🧠 Space Complexity: O(1)
 */

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        double avg = 0.0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        avg = sum / k;
        if (avg >= threshold) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            double a = sum / k;
            if (a >= threshold) {
                count++;
            }
        }

        return count;
    }
}
