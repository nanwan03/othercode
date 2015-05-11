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
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
      return rst;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    TreeNode prev = null;
    stack.push(cur);
    while (!stack.isEmpty()) {
      cur = stack.peek();
      if (prev == null || prev.left ==  cur || prev.right == cur) {
        if (cur.left != null) {
          stack.push(cur.left);
        } else if (cur.right != null) {
          stack.push(cur.right);
        }
      } else if (cur.left == prev) {
        if (cur.right != null) {
          stack.push(cur.right);
        }
      } else {
        stack.pop();
        rst.add(cur.key);
      }
      prev = cur;
    }
    return rst;
  }
}