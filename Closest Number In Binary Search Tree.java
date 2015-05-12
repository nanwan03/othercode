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
  public int closest(TreeNode root, int target) {
    if (root == null) {
      return 0;
    }
    int closet = root.key;
    while (root != null) {
      if (root.key == target) {
        return target;
      } else {
        closet = Math.abs(root.key - target) < Math.abs(closet - target) ? root.key : closet;
        if (target < root.key) {
          root = root.left;
        } else {
          root = root.right;
        }
      }
    }
    return closet;
  }
}