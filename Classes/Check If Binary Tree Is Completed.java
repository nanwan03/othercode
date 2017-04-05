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
    // Write your solution here.
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        return checkQueue(queue);
      } else {
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }
    return true;
  }
  private boolean checkQueue(Queue<TreeNode> queue) {
    if (queue.isEmpty()) {
      return true;
    }
    while (!queue.isEmpty()) {
      if (queue.poll() != null) {
        return false;
      }
    }
    return true;
  }
}
