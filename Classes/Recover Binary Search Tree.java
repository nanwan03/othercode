
public class Solution {
  private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && root.key < prev.key) {
            first = prev;
        }
        if (first != null && root.key < prev.key) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
  public TreeNode recover(TreeNode root) {
    traverse(root);
    int temp = first.key;
    first.key = second.key;
    second.key = temp;
    return root;
  }
}
