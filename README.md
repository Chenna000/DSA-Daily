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

<<<<<<< HEAD
        if(head.next==null){
            head=null;
            return head;
        }
=======
👋 **Hello Everyone!**  
Welcome to my daily DSA journey! This repository contains all the Data Structures & Algorithms problems I'm solving every day, neatly organized by topic with links to Leetcode and my Java solutions.

---
>>>>>>> 011a607d8786c24aef677605067f3c5c1f3a5472

        if(head.next.next==null){
            head.next=null;
            return head;
        }

<<<<<<< HEAD
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow.next != null){
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }

        return head;
    }
}
=======
| #  | Problem Name                                                             | Category | Solution File                                       | Approach               |
|----|--------------------------------------------------------------------------|----------|----------------------------------------------------|------------------------|
| 1  | [Rotate Array](https://leetcode.com/problems/rotate-array/)             | Arrays   | [RotateArray.java](Arrays/RotateArray.java)         | Reverse Array          |
| 2  | [Two Sum](https://leetcode.com/problems/two-sum/)                        | Arrays   | [TwoSum.java](Arrays/TwoSum.java)                   | HashMap                |
| 3  | [Plus One](https://leetcode.com/problems/plus-one/)                      | Arrays   | [PlusOne.java](Arrays/PlusOne.java)                 | Carry-over Loop        |
| 4  | [Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/) | Arrays   | [RunningSum.java](Arrays/RunningSum.java)           | Prefix Sum             |
| 5  | [Move Zeroes](https://leetcode.com/problems/move-zeroes/)               | Arrays   | [MoveZeroes.java](Arrays/MoveZeroes.java)           | Two-pass (ArrayList)   |
| 6  | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)     | Strings  | [RomanToInteger.java](Arrays/RomanToInteger.java)  | HashMap       |
| 7  | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Arrays | [RemoveDuplicates.java](Arrays/RemoveDuplicates.java) | Two Pointers |
| 8  | [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | Arrays | [SortedSquares.java](Arrays/SortedSquares.java) | Square + Sort |
| 9  | [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/) | Arrays | [PivotIndex.java](Arrays/PivotIndex.java) | Prefix + Suffix Sum |
| 10 | [Find the Middle Index in Array](https://leetcode.com/problems/find-the-middle-index-in-array/) | Arrays | [MiddleIndex.java](Arrays/MiddleIndex.java) | Prefix + Suffix Sum |
| 11 | [Majority Element](https://leetcode.com/problems/majority-element/) | Arrays | [MajorityElement.java](Arrays/MajorityElement.java) | Brute Force |

---

## 📌 Follow Me

If you like this repository, consider giving it a ⭐ and follow me on GitHub for more updates!

👉 [**Chenna000 on GitHub**](https://github.com/Chenna000)

---

Thank you for visiting! 💻🔥  

Happy Coding 💙
>>>>>>> 011a607d8786c24aef677605067f3c5c1f3a5472
