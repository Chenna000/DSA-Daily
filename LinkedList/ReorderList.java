/**
 * GFG Problem: Reorder List
 * Link: https://www.geeksforgeeks.org/problems/reorder-list/1
 *
 * ✅ Approach: 
 * 1. Find the middle of the list using slow and fast pointers.
 * 2. Reverse the second half of the list.
 * 3. Merge the two halves alternately.
 *
 * 🧪 Dry Run Example:
 * Input: 1 -> 2 -> 3 -> 4 -> 5
 * Step 1: Find middle → 3
 * Step 2: Reverse second half → 5 -> 4
 * Step 3: Merge:
 *   1 -> 5 -> 2 -> 4 -> 3
 *
 * ⏱️ Time Complexity: O(n)
 * 🧠 Space Complexity: O(1)
 */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    void reorderlist(Node head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        Node secHalf = reverseList(slow.next);
        slow.next = null; // Break the list into two halves

        // Step 3: Merge both halves
        Node firstHalf = head;
        while (secHalf != null) {
            Node temp1 = firstHalf.next;
            Node temp2 = secHalf.next;

            firstHalf.next = secHalf;
            secHalf.next = temp1;

            firstHalf = temp1;
            secHalf = temp2;
        }
    }

    // Helper function to reverse a linked list
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
