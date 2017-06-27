/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
public class Solution {
  public int maxProfit(int[] array, int k) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    if (k >= array.length / 2) {
      int rst = 0;
      for (int i = 1; i < array.length; ++i) {
        if (array[i] > array[i - 1]) {
          rst += array[i] - array[i - 1];
        }
      }
      return rst;
    }
    int[][] dp = new int[k + 1][array.length];
    for (int i = 1; i <= k; ++i) {
      int localMax = dp[i - 1][0] - array[0];
      for (int j = 1; j < array.length; ++j) {
        dp[i][j] = Math.max(dp[i][j - 1], array[j] + localMax);
        localMax = Math.max(localMax, dp[i - 1][j] - array[j]);
      }
    }
    return dp[k][array.length - 1];
  }
}

