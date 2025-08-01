/**
📘 Problem Number: 118
🔗 Problem Link: https://leetcode.com/problems/pascals-triangle/

🧠 Intuition:
- This problem is about generating the first `n` rows of Pascal's Triangle.
- Each element is a binomial coefficient. For row `i`, the j-th value is calculated using the formula:
  `C(i, j) = C(i, j-1) * (i - j) / j`.
- This avoids repeated calculation using factorials.

💡 Approach:
1. Initialize an outer list `al` to hold all rows.
2. Loop from 1 to `n` (1-based indexing to align with Pascal’s Triangle row count).
3. For each row:
   - Initialize `coef = 1` as the first element.
   - Loop `j` from 1 to `i`:
     - Add `coef` to current row.
     - Update `coef = coef * (i - j) / j` to get the next binomial coefficient.
4. Append the row to the main list.
5. Return the main list containing all rows.

🧪 Dry Run:
Input: n = 5

Output:
[
 [1],
 [1, 1],
 [1, 2, 1],
 [1, 3, 3, 1],
 [1, 4, 6, 4, 1]
]

⏱ Time Complexity:
- O(n²): We loop through each row and column of Pascal's Triangle.

📦 Space Complexity:
- O(n²): To store the triangle structure.
*/

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> al = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> al1 = new ArrayList<>();
            int coef = 1;
            for (int j = 1; j <= i; j++) {
                al1.add(coef);
                coef = coef * (i - j) / j;
            }
            al.add(al1);
        }
        return al;
    }
}
