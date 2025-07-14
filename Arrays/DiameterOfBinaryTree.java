/** Hello EveryOne
* LeetCode Problem 543: Diameter of Binary Tree
 * Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Approach:
 * - The diameter of a binary tree is the length of the longest path between any two nodes.
 * - This path may or may not pass through the root.
 * - For each node:
 *    - Compute the height of left and right subtrees.
 *    - Compute the diameter as left height + right height.
 *    - Recursively calculate the diameter for left and right subtrees as well.
 *    - Take the max of all.
 *
 * Time Complexity: O(N^2) in the worst case (since height is recomputed at every node).
 *
 * Example:
 * Input: [1,2,3,4,5]
 * Tree Structure:
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 * Output: 3
 * Explanation: The longest path is [4 → 2 → 1 → 3] or [5 → 2 → 1 → 3], which has 3 edges.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int self = lh + rh;
        return Math.max(Math.max(ld, rd), self);
    }
}
