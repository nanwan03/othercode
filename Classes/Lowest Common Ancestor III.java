
public class Solution {
  private static TreeNode rst;
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // write your solution here
    if (root == null) {
      return null;
    }
    rst = null;
    helper(root, one, two);
    return rst;
  }
  private int helper(TreeNode root, TreeNode one, TreeNode two) {
    if (root == null) {
      return 0;
    }
    int find = 0;
    if (root == one || root == two) {
      find += 1;
    }
    int left = helper(root.left, one, two);
    int right = helper(root.right, one, two);
    find = find + left + right;
    if (find == 2) {
      if (rst == null) {
        rst = root;
      }
    }
    return find;
  }
}
