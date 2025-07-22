/**
 * LeetCode 3217: Delete Nodes From Linked List Present in Array
 * Link: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
 *
 * ✅ Approach:
 * - Use a HashSet to store all values from nums.
 * - Traverse the original linked list.
 * - Construct a new list that skips values found in the set.
 * - Your logic creates a new list without modifying the original one.
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
    public ListNode deleteNodes(ListNode head, int[] nums) {
        // Step 1: Build a HashSet from nums for quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Create dummy node for new list
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;

        // Step 3: Traverse the original list
        ListNode temp = head;
        while (temp != null) {
            // If value is not in set, include it in the new list
            if (!set.contains(temp.val)) {
                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }
            temp = temp.next;
        }

        // Step 4: Return the filtered list
        return newHead.next;
    }
}
