
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
  public int diameter(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return 0;
    }
    return helper(root).maxPath;
  }
  private ResultType helper(TreeNode root) {
    if (root == null) {
      return new ResultType(0, 0);
    }
    ResultType left = helper(root.left);
    ResultType right = helper(root.right);
    int singlePath = Math.max(left.singlePath, right.singlePath) + 1;
    int maxPath;
    if (root.left == null || root.right == null) {
      maxPath = Math.max(left.maxPath, right.maxPath);
    } else {
      maxPath = Math.max(Math.max(left.maxPath, right.maxPath),  left.singlePath + right.singlePath + 1);
    }
    return new ResultType(singlePath, maxPath);
  }
}
