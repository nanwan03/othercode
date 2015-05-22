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
  public boolean isBST(TreeNode root) {
    // write your solution here
    if (root == null) {
      return true;
    }
    long min = Long.MIN_VALUE;
    long max = Long.MAX_VALUE;
    return isBST(root, min, max);
  }
  private boolean isBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.key <= min || root.key >= max) {
      return false;
    }
    return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
  }
}