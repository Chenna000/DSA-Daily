/**
 * LeetCode Problem 2807: Insert Greatest Common Divisors in Linked List
 * Problem Link: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 * 
 * Approach:
 * - Traverse the linked list using two pointers (p and q).
 * - For each adjacent pair (p.val, q.val), compute their GCD.
 * - Insert a new node containing the GCD between p and q.
 * - Move the traversal forward and repeat until the end.
 * 
 * Example:
 * Input: head = [18, 6, 10, 3]
 * Step 1: GCD(18,6) = 6 → insert 6 between 18 and 6
 * Step 2: GCD(6,10) = 2 → insert 2 between 6 and 10
 * Step 3: GCD(10,3) = 1 → insert 1 between 10 and 3
 * Output: [18, 6, 6, 2, 10, 1, 3]
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
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode p = head;
        ListNode q = head.next;

        while (q != null) {
            temp.next = new ListNode(gcd(p.val, q.val));
            temp = p.next;
            temp.next = q;
            p = q;
            q = q.next;
            temp = temp.next;
        }

        return head;
    }
}
