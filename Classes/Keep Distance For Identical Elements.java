public class Solution {
  public int[] keepDistance(int k) {
    // Write your solution here.
    if (k <= 2) {
      return null;
    }
    int[] items = new int[2 * k];
    boolean[] isused = new boolean[k + 1];
    int[] rst = null;
    rst = helper(rst, items, 0, isused, k);
    return rst;
  }
  private int[] helper(int[] rst, int[] items, int index, boolean[] isused, int k) {
    if (index == items.length) {
      rst = Arrays.copyOf(items, items.length);
      return rst;
    }
    if (rst != null) {
    	return rst;
    }
     for (int i = 1; i <= k; ++i) {
      if (!isused[i] && index + i + 1 < items.length
          && items[index] == 0 && items[index + i + 1] == 0) {
        items[index] = i;
        items[index + i + 1] = i;
        isused[i] = true;
        int nextIndex = index + 1;
        while (nextIndex < items.length && items[nextIndex] != 0) {
          nextIndex++;
        }
        rst = helper(rst, items, nextIndex, isused, k);
        isused[i] = false;
        items[index] = 0;
        items[index + i + 1] = 0;
      }
    }
     return rst;
  }
}
