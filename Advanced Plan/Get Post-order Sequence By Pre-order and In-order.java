public class Solution {
  public int[] postOrder(int[] pre, int[] in) {
    // Write your solution here.
    int[] rst = helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    return rst;
  }
  private int[] helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
    int length = preEnd - preStart + 1;
    if (length <= 0) {
      return new int[0];
    }
    if (length == 1) {
      return new int[]{pre[preStart]};
    }
    int root = pre[preStart];
    int rootIndex = findIndex(in, inStart, inEnd, root);
    int leftLength = rootIndex - inStart;
    int rightLength = inEnd - rootIndex;
    int[] left = helper(pre, preStart + 1, preStart + leftLength, in, inStart, rootIndex - 1);
    int[] right = helper(pre, preEnd - rightLength + 1, preEnd, in, rootIndex + 1, inEnd);
    int[] rst = new int[length];
    int index = 0;
    for (int i = 0; i < leftLength; i++) {
      rst[index++] = left[i];
    }
    for (int i = 0; i < rightLength; i++) {
      rst[index++] = right[i];
    }
    rst[index] = root;
    return rst;
  }
  private int findIndex(int[] in, int left, int right, int value) {
    for (int i = left; i <= right; ++i) {
      if (in[i] == value) {
        return i;
      }
    }
    return -1;
  }
}