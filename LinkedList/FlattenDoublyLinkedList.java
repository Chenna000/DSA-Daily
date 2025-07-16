/**
 * LeetCode Problem 430: Flatten a Multilevel Doubly Linked List
 * Problem Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * Approach:
 * - Traverse the list using a pointer `cur`.
 * - If `cur.child` exists:
 *     1. Store the current `cur.next` in `next`.
 *     2. Flatten the child list recursively and connect it to `cur.next`.
 *     3. Set `cur.child = null`.
 *     4. Traverse to the end of the flattened child list.
 *     5. Connect the saved `next` to the tail of the child list.
 * - Continue traversal.
 *
 * Time Complexity: O(n) – each node is visited once.
 * Space Complexity: O(1) extra (recursion uses call stack)
 *
 * Example:
 * Input: 1 - 2 - 3
 *              |
 *              7 - 8
 * Output: 1 - 2 - 3 - 7 - 8
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node cur = head;

        while (cur != null) {
            if (cur.child != null) {

                // 1. Store next node and flatten child
                Node next = cur.next;
                cur.next = flatten(cur.child);
                cur.next.prev = cur;
                cur.child = null;

                // 2. Move to the tail of the child
                while (cur.next != null) {
                    cur = cur.next;
                }

                // 3. Connect tail to original next
                if (next != null) {
                    cur.next = next;
                    next.prev = cur;
                }
            }

            cur = cur.next;
        }

        return head;
    }
}
