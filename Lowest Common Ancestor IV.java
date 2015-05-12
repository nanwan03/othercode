public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // write your solution here
    if (root == null) {
      return null;
    }
    for (TreeNode node : nodes) {
      if (root == node) {
        return root;
      }
    }
    TreeNode left = lowestCommonAncestor(root.left, nodes);
    TreeNode right = lowestCommonAncestor(root.right, nodes);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}