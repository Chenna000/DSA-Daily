/**
 * LeetCode Problem 1290: Convert Binary Number in a Linked List to Integer
 * Problem Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 
 * Approach:
 * - Traverse the linked list and build a binary string using StringBuilder.
 * - Parse the binary string to a decimal integer using Integer.parseInt(..., 2).
 * 
 * Example:
 * Input: head = [1,0,1]
 * Binary string built = "101"
 * Decimal Output = 5
 * 
 * Explanation:
 * Linked List = 1 → 0 → 1
 * Binary value = 101 (base 2)
 * Decimal equivalent = 5
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder temp = new StringBuilder();
        ListNode t = head;
        while (t != null) {
            temp.append(t.val);
            t = t.next;
        }
        int ans = Integer.parseInt(temp.toString(), 2);
        return ans;
    }
}
