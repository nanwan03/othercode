public class Solution {
  public int maxProfit(int[] array) {
    // write your solution here
    if (array == null || array.length < 2) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    for (int i : array) {
      min = Math.min(min, i);
      maxProfit = Math.max(maxProfit, i - min);
    }
    return maxProfit;
  }
}