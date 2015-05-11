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
  public List<Integer> inOrder(TreeNode root) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
      return rst;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.pop();
        rst.add(cur.key);
        cur = cur.right;
      }
    }
    return rst;
  }
}