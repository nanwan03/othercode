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
class QItem
{
   TreeNode node;
   int hd;
   public QItem(TreeNode n, int h)
   {
        node = n;
        hd = h;
   }
}

public class Solution {
  public List<Integer> topView(TreeNode root) {
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    if (root == null) {  
      return left;  
    }
    
    Set<Integer> set = new HashSet<Integer>();
    Queue<QItem> queue = new LinkedList<QItem>();
    queue.offer(new QItem(root, 0));
    while (!queue.isEmpty())
    {
        QItem node = queue.remove();
        int hd = node.hd;
        TreeNode n = node.node;

        if (!set.contains(hd))
        {
            set.add(hd);
            if (hd <= 0) {
              left.add(n.key);
            } else {
              right.add(n.key);
            }
        }

        // Enqueue left and right children of current node
        if (n.left != null)
            queue.offer(new QItem(n.left, hd-1));
        if (n.right != null)
            queue.add(new QItem(n.right, hd+1));
    }
    Collections.reverse(left);
    left.addAll(right);
    return left;
  }
}