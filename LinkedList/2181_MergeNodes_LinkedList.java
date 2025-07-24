/**
 * ✅ LeetCode Problem: 2181. Merge Nodes in Between Zeros
 * 🔗 Link: https://leetcode.com/problems/merge-nodes-in-between-zeros/
 * 
 * ✅ Approach:
 * - Traverse the list starting from the second node.
 * - Accumulate the sum of nodes until a zero is encountered.
 * - Each time a zero is found, create a new node with the accumulated sum.
 * - Link all such nodes into a new list using a dummy node.
 * 
 * ✅ Dry Run Example:
 * Input: [0,3,1,0,4,5,2,0]
 * Steps:
 * - 3 + 1 → 4 → new node
 * - 4 + 5 + 2 → 11 → new node
 * Output: [4,11]
 * 
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n) – for the new list (or O(1) if modifying in place)
 */

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        int sum = 0;
        ListNode r = head.next; // Start after the initial 0

        while (r != null) {
            if (r.val == 0) {
                // End of one segment
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            } else {
                sum += r.val;
            }
            r = r.next;
        }

        return dummy.next;
    }
}
