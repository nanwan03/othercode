public class Solution {
  public int[] keepDistance(int k) {
    // Write your solution here.
    int[] rst = new int[k * 2];
    if (k == 0) {
      return rst;
    }
    Deque<Integer> deque = new LinkedList<Integer>();
    for (int i = 1; i <= k; ++i) {
      deque.offerFirst(i);
    }
    return helper(rst, deque, 0);
  }
  private int[] helper(int[] rst, Deque<Integer> deque, int index) {
    if (index == rst.length) {
      return rst;
    }
    int size = deque.size();
    for (int i = 0; i < size; ++i) {
      int cur = deque.pollFirst();
      int nextIndex = cur + index + 1;
      if (index < rst.length && nextIndex < rst.length && rst[index] == 0 && rst[nextIndex] == 0) {
        rst[index] = cur;
        rst[nextIndex ] = cur;
        int nextCur = index + 1;
        while (nextCur < rst.length && rst[nextCur] != 0) {
          nextCur++;
        }
        if(helper(rst, deque, nextCur) != null) {
          return rst;
        }
        rst[index] = 0;
        rst[nextIndex] = 0;
      }
      deque.offerLast(cur);
    }
    return null;
  }
}
