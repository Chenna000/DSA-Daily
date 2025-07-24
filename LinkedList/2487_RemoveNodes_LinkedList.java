/**
 * ✅ LeetCode Problem: 2487. Remove Nodes From Linked List
 * 🔗 Link: https://leetcode.com/problems/remove-nodes-from-linked-list/
 * 
 * ✅ Approach:
 * 1. Use a stack to keep track of nodes in decreasing order.
 * 2. Traverse from left to right:
 *    - If current node’s value is greater than top of stack, pop until the stack has larger elements.
 *    - Push current node to stack.
 * 3. Stack now has the required nodes in reverse order, so reconstruct the list backwards.
 * 4. Return the new head of the reconstructed list.
 * 
 * ✅ Dry Run Example:
 * Input: [5,2,13,3,8]
 * Stack processing:
 *  - 5 → push
 *  - 2 < 5 → push
 *  - 13 > 2,5 → pop 2, pop 5 → push 13
 *  - 3 < 13 → push
 *  - 8 > 3 → pop 3 → push 8
 * Stack (top to bottom): [13,8]
 * Reconstructed list: [13 -> 8]
 * Output: [13,8]
 * 
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n) – for stack
 */

class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> st = new Stack<>();

        while (cur != null) {
            while (!st.isEmpty() && st.peek().val < cur.val) {
                st.pop();
            }
            st.push(cur);
            cur = cur.next;
        }

        // Reconstruct the list from the stack (reverse order)
        ListNode nxt = null;
        while (!st.isEmpty()) {
            cur = st.pop();
            cur.next = nxt;
            nxt = cur;
        }

        return cur;
    }
}
