/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  private class ResultType {
    int singlePath;
    int maxPath;
    ResultType(int singlePath, int maxPath) {
      this.singlePath = singlePath;
      this.maxPath = maxPath;
    }
  }
  public int maxPathSum(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    return helper(root).maxPath;
  }
  private ResultType helper(TreeNode root) {
    if (root == null) {
      return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    ResultType left = helper(root.left);
    ResultType right = helper(root.right);
    int singlePath;
    if (root.left == null && root.right == null) {
      singlePath = root.key;
    } else {
      singlePath = Math.max(left.singlePath, right.singlePath) + root.key;
    }
    int maxPath;
    if (root.left == null || root.right == null) {
      maxPath = Math.max(left.maxPath, right.maxPath);
    } else {
      maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath + right.singlePath + root.key);
    }
    return new ResultType(singlePath, maxPath);
  }
}
