/*
 * Leetcode 66: Plus One
 * https://leetcode.com/problems/plus-one/
 *
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * Digits are stored such that the most significant digit is at the head of the list.
 *
 * Approach: Start from the end of the array, handle carry (9 -> 0), else add 1 and return.
 * Time Complexity: O(n), Space Complexity: O(1)
 */
// if digits[]=[9,9,9]
class Solution {
    public int[] plusOne(int[] digits) {  //999
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[digits.length + 1]; //0000
        digits[0] = 1; // 1000
        return digits;// output - 1000
    }
}
