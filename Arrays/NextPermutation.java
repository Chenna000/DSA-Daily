/**
📘 Problem Number: 31
🔗 Problem Link: https://leetcode.com/problems/next-permutation/

🧠 Intuition:
- The goal is to rearrange the array into the next lexicographically greater permutation.
- If such a permutation doesn’t exist (i.e., the array is sorted in descending order), we reverse it to get the smallest possible order.
- We need to identify a pair of elements where the left is smaller than the right (from the back), swap them appropriately, and then reverse the remaining suffix to get the next permutation.

💡 Approach:
1. Start from the right and find the first index `i` such that nums[i] < nums[i+1]. This is the pivot (stIdx).
2. If such a pivot is found:
   - Traverse from the end to find the smallest number greater than nums[stIdx], say at swapIdx.
   - Swap nums[stIdx] with nums[swapIdx].
3. Reverse the subarray from stIdx + 1 to end to get the next permutation.
4. If no pivot was found, it means the array is in descending order, so we just reverse the whole array.

🧪 Dry Run:
Input: [1, 2, 3]
- Find pivot: nums[1] = 2 < nums[2] = 3, so stIdx = 1
- Find swapIdx: nums[2] = 3 > nums[1] = 2, so swapIdx = 2
- Swap: [1, 3, 2]
- Reverse from index 2 onwards (no change) → Output: [1, 3, 2]

Input: [3, 2, 1]
- No pivot found → reverse entire array → Output: [1, 2, 3]

⏱ Time Complexity:
- O(n): One traversal to find pivot and swapIdx, and another to reverse the suffix.

📦 Space Complexity:
- O(1): In-place modification without extra space.
*/

class Solution {
    public void nextPermutation(int[] nums) {

        int stIdx = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                stIdx = i - 1;
                break;
            }
        }

        if (stIdx != -1) {
            int swapIdx = stIdx;

            for (int j = nums.length - 1; j >= stIdx + 1; j--) {
                if (nums[j] > nums[stIdx]) {
                    swapIdx = j;
                    break;
                }
            }
            int temp = nums[swapIdx];
            nums[swapIdx] = nums[stIdx];
            nums[stIdx] = temp;
        }
        reverse(nums, stIdx + 1);
    }

    public static void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        int startIdx = start;
        while (startIdx < end) {
            int temp = arr[startIdx];
            arr[startIdx] = arr[end];
            arr[end] = temp;

            startIdx++;
            end--;
        }
    }
}
