/**
 * LeetCode Problem 25: Reverse Nodes in k-Group
 * Problem Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Approach:
 * - First, check if at least `k` nodes are available from the current node.
 *   - If fewer than `k` remain, return the head as-is.
 * - If `k` nodes are available:
 *   - Recursively reverse the next group and hold its reference in `prevNode`.
 *   - Reverse the current `k` nodes, and attach the reversed `prevNode` at the end.
 *
 * - Recursive logic builds the list backwards with reversed groups.
 *
 * Time Complexity: O(n), where n is the number of nodes.
 * Space Complexity: O(n/k) recursive calls due to stack.
 *
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Step 1: Reverse 1-2 → [2,1]
 * Step 2: Reverse 3-4 → [4,3]
 * Step 3: Leave 5 → [5]
 * Output: 2 → 1 → 4 → 3 → 5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode temp = head;

        // Check if at least k nodes exist
        while (cnt < k) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
            cnt++;
        }

        // Recursive call on the remaining list
        ListNode prevNode = reverseKGroup(temp, k);

        // Reverse current group
        temp = head;
        cnt = 0;
        while (cnt < k) {
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            cnt++;
        }

        return prevNode;
    }
}
