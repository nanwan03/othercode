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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
      return rst;
    }
    helper(rst, root, min, max);
    return rst;
  }
  private void helper(List<Integer> rst, TreeNode root, int min, int max) {
    if (root == null) {
      return;
    }
    if (min < root.key) {
      helper(rst, root.left, min, max);
    }
    if (min <= root.key && root.key <= max) {
      rst.add(root.key);
    }
    if (root.key < max) {
      helper(rst, root.right, min, max);
    }
  }
}