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
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
      return rst;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      rst.add(node.key);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return rst;
  }
}