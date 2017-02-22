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
  private int level = 0;
  public List<Integer> rightView(TreeNode root) {
    // Write your solution here.
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
        return rst;
    }
    helper(root, rst, 0);
    return rst;
  }
  private void helper(TreeNode root, List<Integer> rst, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel == level) {
            rst.add(root.key);
            level++;
        }
        helper(root.right, rst, curLevel + 1);
        helper(root.left, rst, curLevel + 1);
    }
}