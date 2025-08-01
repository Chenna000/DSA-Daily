/**
📘 Problem Number: 560  
🔗 Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/

🧠 Intuition:
- We want to count the number of subarrays whose sum equals `k`.
- Brute force checks all subarrays using nested loops — O(n²) time.
- With the **prefix sum + hashmap** approach, we can achieve this in O(n) time.

💡 Approach:
1. Maintain a running `prefixSum` and a HashMap to store frequency of each prefix sum seen so far.
2. For each number in the array:
   - Add it to `prefixSum`.
   - Check if `(prefixSum - k)` exists in the map — this indicates a valid subarray.
   - Add the frequency of `(prefixSum - k)` to `count`.
   - Update the frequency of `prefixSum` in the map.
3. Initialize the map with `(0,1)` to handle the case where a subarray starting from index 0 has sum `k`.

🧪 Dry Run:
Input: nums = [1, 2, 3], k = 3  
prefixSum: 1 → 3 → 6  
prefixSumFreq Map:  
- After 1: {0:1, 1:1}  
- After 2: {0:1, 1:1, 3:1} → 3 - 3 = 0 exists → count += 1  
- After 3: {0:1, 1:1, 3:1, 6:1} → 6 - 3 = 3 exists → count += 1  
Output: 2

⏱ Time Complexity:
- O(n): Single pass through the array with constant-time map operations.

📦 Space Complexity:
- O(n): For the HashMap storing prefix sums.
*/

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        prefixSumFrequency.put(0, 1); // handle sum from beginning

        for (int num : nums) {
            prefixSum += num;

            if (prefixSumFrequency.containsKey(prefixSum - k)) {
                count += prefixSumFrequency.get(prefixSum - k);
            }

            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
