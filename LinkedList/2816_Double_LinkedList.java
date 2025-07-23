/**
 * ✅ LeetCode Problem: 2816. Double a Number Represented as a Linked List
 * 🔗 Link: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
 * 
 * ✅ Approach:
 * 1. Reverse the linked list to simplify digit-by-digit processing from least significant digit.
 * 2. Multiply each digit by 2 and handle carry.
 * 3. Construct a new list with the resulting digits.
 * 4. Reverse the result list again to restore original digit order.
 * 
 * ✅ Dry Run Example:
 * Input: [1,8,9] (represents 189)
 * Step 1: Reverse → [9,8,1]
 * Step 2:
 *   - 9*2 = 18 → digit=8, carry=1
 *   - 8*2+1 = 17 → digit=7, carry=1
 *   - 1*2+1 = 3 → digit=3, carry=0
 * Result (reversed): [8,7,3] → Final result after reverse: [3,7,8]
 * Output: [3,7,8] (represents 378)
 * 
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n) – for constructing the result list
 */

class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (head != null) {
            int sum = head.val * 2 + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            head = head.next;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }

    // Helper function to reverse the linked list
    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
