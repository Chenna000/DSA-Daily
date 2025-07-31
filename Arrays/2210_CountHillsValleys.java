/*
🔖 LeetCode Title: Count Hills and Valleys in an Array
📘 Problem Number: 2210
🔗 Problem Link: https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

🧠 Intuition:
- A hill is a point that is strictly greater than its closest non-equal neighbors.
- A valley is a point that is strictly smaller than its closest non-equal neighbors.
- Consecutive equal elements should be ignored when checking for hills or valleys.

💡 Approach:
1. Traverse the array from index 1 to n-2.
2. Skip the index if nums[i] == nums[i - 1] to handle flat plateaus.
3. For each nums[i], find the nearest non-equal neighbor to the left and right.
4. If nums[i] > both neighbors, it’s a hill.
5. If nums[i] < both neighbors, it’s a valley.
6. Count both and return the total.

🧪 Dry Run:
Input: [2, 4, 1, 1, 6, 5]
- i = 1 → nums[1] = 4 → left = 2, right = 1 → hill ✅ → hillCount = 1
- i = 2 → nums[2] == nums[3] → skip
- i = 3 → nums[3] = 1 → left = 4, right = 6 → valley ✅ → valleyCount = 1
- i = 4 → nums[4] = 6 → left = 1, right = 5 → hill ✅ → hillCount = 2
Output: 3

⏱ Time Complexity:
- Worst-case O(n²) due to scanning left and right for each index.
- Can be optimized to O(n) with smarter traversal and skipping.

📦 Space Complexity:
- O(1), using constant extra space.

class Solution {
    public int countHillValley(int[] nums) {
        int hillCount = 0;
        int valleyCount = 0;
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            int left = findLeftNonEqualValue(nums, i);
            int right = findRightNonEqualValue(nums, i);

            if (nums[i] > left && nums[i] > right) {
                hillCount++;
            } else if (nums[i] < left && nums[i] < right) {
                valleyCount++;
            }
        }

        return hillCount + valleyCount;
    }

    // Helper to find the nearest non-equal value on the left of index i
    public static int findLeftNonEqualValue(int[] nums, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] != nums[i]) {
                return nums[j];
            }
        }
        return nums[i];
    }

    // Helper to find the nearest non-equal value on the right of index i
    public static int findRightNonEqualValue(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                return nums[j];
            }
        }
        return nums[i];
    }
}
