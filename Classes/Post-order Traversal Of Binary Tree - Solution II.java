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
  public List<Integer> postOrder(TreeNode root) {
    // write your solution here
    Stack<TreeNode> stack = new Stack<TreeNode>();
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
        return rst;
    }
    stack.push(root);
    while (!stack.empty()) {
        TreeNode temp = stack.pop();
        if (temp != null) {
            rst.add(temp.key);
        }
        if (temp.left != null) {
            stack.push(temp.left);
        }
        if (temp.right != null) {
            stack.push(temp.right);
        }
    }
    Collections.reverse(rst);
    return rst;
  }
}