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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // write your solution here
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (root == null) {
      return rst;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
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
      rst.add(items);
    }
    return rst;
  }
}