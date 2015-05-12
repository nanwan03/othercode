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
  public boolean exist(TreeNode root, int target) {
    if (root == null) {
      return false;
    }
    return exist(root.left, target) || exist(root.right, target) || hasPathSum(root, target);
  }
  private boolean hasPathSum(TreeNode root, int target) {
    if (root == null) {
      return false;
    }
    target -= root.key;
    if (root.left == null && root.right == null && target == 0) {
      return true;
    }
    return hasPathSum(root.left, target) || hasPathSum(root.right, target);
  }
}