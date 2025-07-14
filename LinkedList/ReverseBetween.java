/**
 * LeetCode Problem 92: Reverse Linked List II
 * Problem Link: https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Approach:
 * - Store all node values into an array for easier manipulation.
 * - Reverse only the part of the array between 'left' and 'right' indices.
 * - Construct a new linked list using the updated array.
 * 
 * Note:
 * - This is a space-heavy approach (O(N) extra space).
 * - Time Complexity: O(N) for array creation and list reconstruction.
 *
 * Example:
 * Input: head = [1, 2, 3, 4, 5], left = 2, right = 4
 * Step-by-step:
 * Original array = [1, 2, 3, 4, 5]
 * After reversing elements from index 2 to 4 → [1, 4, 3, 2, 5]
 * Output: Linked List = 1 → 4 → 3 → 2 → 5
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if ((left == right) || head == null) {
            return head;
        }

        int len = 0;
        ListNode t1 = head;

        // Count length
        while (t1 != null) {
            len++;
            t1 = t1.next;
        }

        // Copy node values to array
        int[] arr = new int[len];
        int in = 0;
        t1 = head;
        while (t1 != null) {
            arr[in++] = t1.val;
            t1 = t1.next;
        }

        // Reverse subarray from left-1 to right-1
        while (left < right) {
            int temp = arr[right - 1];
            arr[right - 1] = arr[left - 1];
            arr[left - 1] = temp;
            left++;
            right--;
        }

        // Rebuild linked list from modified array
        ListNode dummy = new ListNode(-501);
        ListNode tail = dummy;
        for (int num : arr) {
            ListNode newNode = new ListNode(num);
            tail.next = newNode;
            tail = tail.next;
        }

        return dummy.next;
    }
}
