/*
 * Leetcode 13: Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 *
 * Approach:
 * Use a HashMap to store values of Roman characters.
 * Traverse from left to right. If current value < next value, subtract it. Else, add it.
 * Time Complexity: O(n), Space Complexity: O(1)
 */

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            if (i < s.length() - 1 && cur < map.get(s.charAt(i + 1))) {
                res -= cur;
            } else {
                res += cur;
            }
        }

        return res;
    }
}
