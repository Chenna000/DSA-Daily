/**
 * LeetCode 1019: Next Greater Node In Linked List
 * Link: https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * ✅ Approach 1: Brute Force (O(n^2))
 * ✅ Approach 2: Monotonic Stack (O(n))
 *
 * ⏱️ Time Complexity: Brute: O(n^2), Stack: O(n)
 * 🧠 Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    // ✅ Optimized Approach using Monotonic Stack
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        // Step 1: Calculate length of list
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // Step 2: Convert list to array
        int[] arr = new int[len];
        temp = head;
        for (int i = 0; i < len; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        // Step 3: Process using monotonic decreasing stack
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                ans[index] = arr[i];
            }
            stack.push(i);
        }

        return ans;
    }

    // ✅ Brute Force Approach (for reference)
    public int[] nextLargerNodesBrute(ListNode head) {
        ListNode temp = head;
        int len = 0;

        // Step 1: Find length
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] res = new int[len];
        temp = head;
        int idx = 0;

        // Step 2: For each node, look ahead for next greater
        while (temp != null) {
            res[idx++] = findNextVal(temp.val, temp.next);
            temp = temp.next;
        }

        return res;
    }

    // Helper for Brute Force
    private int findNextVal(int curr, ListNode temp) {
        while (temp != null) {
            if (curr < temp.val) return temp.val;
            temp = temp.next;
        }
        return 0;
    }
}
