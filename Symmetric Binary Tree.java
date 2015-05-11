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
  public boolean isSymmetric(TreeNode root) {
    // write your solution here
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }
  private boolean isSymmetric(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }
    if (node1.key != node2.key) {
      return false;
    }
    return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
  }
}