public class Solution {
  public int[] keepDistance(int k) {
    // Write your solution here.
    if (k <= 2) {
      return null;
    }
    int[] items = new int[2 * k];
    boolean[] isused = new boolean[k + 1];
    int[] rst = null;
    rst = helper(rst, items, isused, k, k);
    return rst;
  }
  private int[] helper(int[] rst, int[] items, boolean[] isused, int k, int left) {
    if (left == 0) {
      rst = Arrays.copyOf(items, items.length);
      return rst;
    }
    if (rst != null) {
    	return rst;
    }
    int index = 0;
    while (index < items.length && items[index] != 0) {
    	index++;
    }
     for (int i = 1; i <= k; ++i) {
      if (!isused[i] && index + i + 1 < items.length
          && items[index] == 0 && items[index + i + 1] == 0) {
        items[index] = i;
        items[index + i + 1] = i;
        isused[i] = true;
        rst = helper(rst, items, isused, k, left - 1);
        isused[i] = false;
        items[index] = 0;
        items[index + i + 1] = 0;
      }
    }
     return rst;
  }
}
