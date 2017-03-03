
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
  public TreeNode construct(int[] level) {
    // Write your solution here.
    if (level == null || level.length == 0) {
      return null;
    }
    return helper(level, 0);
  }
  private TreeNode helper(int[] level, int index) {
    if (index >= level.length) {
      return null;
    }
    TreeNode root = new TreeNode(level[index]);
    root.left = helper(level, index * 2 + 1);
    root.right = helper(level, index * 2 + 2);
    return root;
  }
}
