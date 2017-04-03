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
  public TreeNode greaterSum(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return root;
    }
    helper(root, 0);
    return root;
  }
  private int helper(TreeNode root, int val) {
    if (root == null) {
      return val;
    }
    int rootVal = root.key;
    int rightSum = helper(root.right, val);
    root.key = rightSum;
    int leftSum = helper(root.left, rightSum + rootVal);
    return leftSum;
  }
}