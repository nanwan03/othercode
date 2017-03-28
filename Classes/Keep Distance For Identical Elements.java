public class Solution {
  public int[] keepDistance(int k) {
    // Write your solution here.
    if (k == 0) {
      return null;
    }
    boolean[] isused = new boolean[k + 1];
    return helper(new int[k * 2], k, isused, 0);
  }
  private int[] helper(int[] items, int k, boolean[] isused, int index) {
    if (index == items.length) {
      return items;
    }
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
        if (helper(items, k, isused, nextIndex) != null) {
          return items;
        }
        isused[i] = false;
        items[index] = 0;
        items[index + 1 + i] = 0;
      }
    }
    return null;
  }
}
