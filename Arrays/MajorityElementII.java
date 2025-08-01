/**
📘 Problem Number: 229  
🔗 Problem Link: https://leetcode.com/problems/majority-element-ii/

🧠 Intuition:
- A majority element is one that appears more than ⌊ n/3 ⌋ times in the array.
- There can be **at most 2 majority elements** in this case.
- Using a HashMap, we can count occurrences and check for elements exceeding n/3.

💡 Approach:
1. Initialize a HashMap to store element counts.
2. Traverse the array and update frequency using `map.getOrDefault(nums[i], 0) + 1`.
3. Traverse the map keys:
   - If frequency > ⌊ n/3 ⌋, add the key to the result list.
4. Return the result list.

🧪 Dry Run:
Input: [3, 2, 3]  
- Frequency map: {3:2, 2:1}  
- n = 3, so n/3 = 1  
- Elements > 1: 3 → Output: [3]

⏱ Time Complexity:
- O(n): One pass to count and another to collect results.

📦 Space Complexity:
- O(n): For the HashMap used to store frequencies.
*/

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > (size / 3)) {
                res.add(key);
            }
        }
        return res;
    }
}
