public class Solution {
  class SegmentTreeNode {
         public int start, end;
         public int cover;
         public SegmentTreeNode left, right;
         public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.cover = end - start + 1;
        }
  }
  
  private SegmentTreeNode buildTree(int start, int end) {
    if (start > end) {
        return null;
    }
    if (start == end) {
        return new SegmentTreeNode(start, end);
    }
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    root.left = buildTree(start, (start + end ) / 2);
    root.right = buildTree((start + end) / 2 + 1, end);
    return root;
  }

  private void removeNode(SegmentTreeNode root, int val) {
    if(root == null) {
      return;
    }
    --root.cover;
    if(root.left != null && root.left.start == val && root.left.end == val) {
        root.left = null;
        return;
    } else if(root.right != null && root.right.start == val && root.right.end == val) {
        root.right = null;
        return;
    }
    int mid = root.start + (root.end - root.start) / 2;
    if(val <= mid) {
        removeNode(root.left, val);
    } else {
        removeNode(root.right, val);
    }
  }
  
  private int getKth(SegmentTreeNode root, int k) {
    SegmentTreeNode cur = root;
    while(cur != null) {
        if(k == 0 && cur.left == null && cur.right == null) {
          return cur.start;
        }
        int leftCover = cur.left != null ? cur.left.cover : 0;
        if(k < leftCover) {
            cur = cur.left;
        } else {
            k -= leftCover;
            cur = cur.right;
        }
    }
    return -1;
  } 
  
  public int[] restore(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return new int[0];
    }
    int[] rst = new int[array.length];
    int index = 0;
    SegmentTreeNode root = buildTree(1, array.length);
    for (int i : array) {
      int kth = getKth(root, i);
      rst[index++] = kth;
      removeNode(root, kth);
    }
    return rst;
  }
}