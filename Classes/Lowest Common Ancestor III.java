public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    if (root == null) {
      return null;
    }
    List<TreeNode> rst = new ArrayList<TreeNode>();
    int find = helper(rst, root, one, two);
    if (!rst.isEmpty()) {
      return rst.get(0);
    } else {
      return null;
    }
  }
  private int helper(List<TreeNode> rst, TreeNode root, TreeNode one, TreeNode two) {
    if (root == null) {
      return 0;
    }
    int find = 0;
    if (root == one || root == two) {
      find += 1;
    }
    int left = helper(rst, root.left, one, two);
    int right = helper(rst, root.right, one, two);
    find = find + left + right;
    if (find == 2) {
      if (rst.isEmpty()) {
        rst.add(root);
      }
    }
    return find;
  }
}