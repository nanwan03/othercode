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
  public List<Integer> zigZag(TreeNode root) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (root == null) {
      return rst;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    boolean reverse = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> items = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        items.add(node.key);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      if (reverse) {
        Collections.reverse(items);
      }
      rst.addAll(items);
      reverse ^= true;
    }
    return rst;
  }
}