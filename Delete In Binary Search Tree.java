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
  public TreeNode delete(TreeNode root, int key) {
    if (root == null) {
      return root;
    }
    if (root.key < key) {
      root.right = delete(root.right, key);
      return root;
    } else if (key < root.key) {
      root.left = delete(root.left, key);
      return root;
    } else if (root.right == null) {
      return root.left;
    } else if (root.left == null) {
      return root.right;
    } else if (root.right.left == null) {
      root.right.left = root.left;
      return root.right;
    } else {
      TreeNode smallest = getSmallest(root.right);
      smallest.left = root.left;
      smallest.right = root.right;
      return smallest;
    }
  }
  private TreeNode getSmallest(TreeNode root) {
    while (root.left.left != null) {
      root = root.left;
    }
    TreeNode smallest = root.left;
    root.left = smallest.right;
    return smallest;
  }
}