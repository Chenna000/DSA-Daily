/**
 * LeetCode Problem 3: Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * ✅ Approach: Sliding Window with HashSet
 * - Maintain a window of unique characters.
 * - Expand the window by moving 'right', and contract by moving 'left' when a duplicate is found.
 * - Keep track of the maximum length found.
 *
 * 🧪 Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * 🔍 Dry Run:
 * s = "abcabcbb"
 * 
 * right = 0 → 'a' not in set → add 'a' → maxLen = 1
 * right = 1 → 'b' not in set → add 'b' → maxLen = 2
 * right = 2 → 'c' not in set → add 'c' → maxLen = 3
 * right = 3 → 'a' is duplicate → remove 'a' (left++) → add 'a' → maxLen = 3
 * right = 4 → 'b' is duplicate → remove 'b' (left++) → add 'b' → maxLen = 3
 * right = 5 → 'c' is duplicate → remove 'c' (left++) → add 'c' → maxLen = 3
 * right = 6 → 'b' is duplicate → remove 'a','b' (left++) → add 'b' → maxLen = 3
 * right = 7 → 'b' is duplicate → remove 'c','b' (left++) → add 'b' → maxLen = 3
 *
 * Final Result = 3 ("abc")
 *
 * ⏱️ Time Complexity: O(n)
 * 🧠 Space Complexity: O(n) → for HashSet to store characters in the current window
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Shrink the window until there's no duplicate
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));
            maxLen = Math.max(maxLen, window.size());
        }

        return maxLen;
    }
}
