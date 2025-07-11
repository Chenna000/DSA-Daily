/*
 * Leetcode 2095: Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 *
 * ✅ Approach (Same Logic as Provided):
 * - If the list has only one node, return null.
 * - If the list has two nodes, delete the second one.
 * - Use slow and fast pointers to find the middle node.
 * - Instead of deleting by previous pointer, overwrite the middle node's value
 *   with its next and skip the next node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * ✅ Example:
 * Input: 1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
 * Output: 1 -> 3 -> 4 -> 1 -> 2 -> 6 (middle '7' is removed)
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
    public ListNode deleteMiddle(ListNode head) {

        // If list contains only one node
        if (head.next == null) {
            head = null;
            return head;
        }

        // If list contains only two nodes
        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Find middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Overwrite current slow node with next
        if (slow.next != null) {
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }

        return head;
    }
}
