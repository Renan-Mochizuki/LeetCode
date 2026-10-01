/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    return dfs(p, q);
  }

  private boolean dfs(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null) {
      return false;
    }
    if (q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }

    if (!dfs(p.left, q.left)) {
      return false;
    }
    if (!dfs(p.right, q.right)) {
      return false;
    }
    return true;
  }
}