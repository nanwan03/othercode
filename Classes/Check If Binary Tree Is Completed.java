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
  public boolean isCompleted(TreeNode root) {
    // write your solution here
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    boolean hasNull = false;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        hasNull = true;
      } else if (hasNull) {
        return false;
      } else {
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }
    return true;
  }
}