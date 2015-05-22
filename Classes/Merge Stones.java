public class Solution {
  public int minCost(int[] stones) {
    if (stones == null || stones.length == 0) {
      return 0;
    }
    int[][] dp = new int[stones.length][stones.length];
    int[][] sum = new int[stones.length][stones.length];
    for (int end = 0; end < stones.length; end++) {
      for (int start = end; start >= 0; start--) {
        dp[start][end] = Integer.MAX_VALUE;
        if (start == end) {
          dp[start][end] = 0;
          sum[start][end] = stones[end];
        } else {
          sum[start][end] = sum[start][end - 1] + stones[end];
          for (int k = end - 1; k >= start; k--) {
            dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + sum[start][end]);
          }
        }
      }
    }
    return dp[0][stones.length - 1];
  }
}