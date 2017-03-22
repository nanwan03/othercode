public class Solution {
  public int[] keepDistance(int k) {
    // Write your solution here.
    if (k <= 2) {
      return null;
    }
    int[] items = new int[k * 2];
    boolean[] isused = new boolean[k + 1];
    return helper(items, 0, isused, k);
  }
  private int[] helper(int[] items, int index, boolean[] isused, int k) {
    if (index == items.length) {
      return Arrays.copyOf(items, items.length);
    }
    int[] rst = null;
    for (int i = 1; i <= k; ++i) {
      if (!isused[i] && index + 1 + i < items.length
        && items[index] == 0 && items[index + 1 + i] == 0) {
          items[index] = i;
          items[index + 1 + i] = i;
          isused[i] = true;
          int nextIndex = index + 1;
          while (nextIndex < items.length && items[nextIndex] != 0) {
            nextIndex++;
          }
          rst = helper(items, nextIndex, isused, k);
          if (rst != null) {
            return rst;
          }
          isused[i] = false;
          items[index] = 0;
          items[index + 1 + i] = 0;
        }
    }
    return rst;
  }
}
