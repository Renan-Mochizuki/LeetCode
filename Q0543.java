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
  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depthSearch(root, 0);

    return max;
  }

  // Aqui jaz o pior código do mundo, só deus sabe o que eu fiz
  private int depthSearch(TreeNode subRoot, int depth) {
    int longestDepthLeft = depth;
    int longestDepthRight = depth;
    int computedDepth;

    if (subRoot.left == null) {
      computedDepth = depth;
    } else {
      computedDepth = depthSearch(subRoot.left, depth + 1);
    }

    if (computedDepth > longestDepthLeft) {
      longestDepthLeft = computedDepth;
    }

    if (subRoot.right == null) {
      computedDepth = depth;
    } else {
      computedDepth = depthSearch(subRoot.right, depth + 1);
    }

    if (computedDepth > longestDepthRight) {
      longestDepthRight = computedDepth;
    }

    int diameter = longestDepthLeft - depth + longestDepthRight - depth;
    if (diameter > this.max) {
      this.max = diameter;
    }

    return Math.max(longestDepthLeft, longestDepthRight);
  }
}