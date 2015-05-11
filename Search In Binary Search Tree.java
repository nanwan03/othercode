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
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here.
    if (root == null) {
      return root;
    }
    while (root != null) {
      if (root.key == key) {
        return root;
      }
      if (root.key < key) {
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return null;
  }
}