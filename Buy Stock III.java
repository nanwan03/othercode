public class Solution {
  public int maxProfit(int[] array) {
    // write your solution here
    if (array == null || array.length < 2) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    int[] left = new int[array.length];
    for (int i = 0; i < left.length; i++) {
      min = Math.min(min, array[i]);
      maxProfit = Math.max(maxProfit, array[i] - min);
      left[i] = maxProfit;
    }
    maxProfit = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    int[] right = new int[array.length];
    for (int i = array.length - 1; i >= 0; i--) {
      max = Math.max(max, array[i]);
      maxProfit = Math.max(maxProfit, max - array[i]);
      right[i] = maxProfit;
    }
    int rst = Integer.MIN_VALUE;
    for (int i = 0; i< array.length; i++) {
      rst = Math.max(rst, left[i] + right[i]);
    }
    return rst;
  }
}