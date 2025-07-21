/**
 * LeetCode Problem 2130: Maximum Twin Sum of a Linked List
 * Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 *
 * ✅ Approach: Two Pointers + Reverse Second Half
 * - Use fast and slow pointers to find the middle node.
 * - Reverse the second half of the linked list.
 * - Iterate both halves together and compute the maximum twin sum.
 *
 * 🧪 Dry Run Example:
 * Input: head = [1,2,3,4]
 * Step 1: After finding mid → firstHalf = [1,2], reversed secondHalf = [4,3]
 * Step 2:
 *     1 + 4 = 5
 *     2 + 3 = 5
 * Output: 5 (maximum twin sum)
 *
 * ⏱️ Time Complexity: O(n)
 * 🧠 Space Complexity: O(1) — in-place reversal
 */

class Solution {
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare first half and reversed second half
        ListNode firstHalf = head;
        int maxSum = 0;
        while (secondHalf != null) {
            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

    // Helper to reverse linked list
    public ListNode reverseList(ListNode h) {
        ListNode cur = h;
        ListNode next = null;
        ListNode prev = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
