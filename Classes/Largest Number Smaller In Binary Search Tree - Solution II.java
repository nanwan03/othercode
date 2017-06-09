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
  public int largestSmaller(TreeNode root, int target) {
    // Write your solution here.
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    if (target <= root.key) {
      return largestSmaller(root.left, target);
    } else {
      return Math.max(root.key, largestSmaller(root.right, target));
    }
  }
}
