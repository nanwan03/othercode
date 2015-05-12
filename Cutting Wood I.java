public class Solution {
  public int minCost(int[] cuts, int length) {
    if (cuts == null || cuts.length == 0) {
      return 0;
    }
    int[] helper = new int[cuts.length + 2];
    helper[0] = 0;
    helper[helper.length - 1] = length;
    for (int i = 0; i < cuts.length; i++) {
      helper[i + 1] = cuts[i];
    }
    int[][] dp = new int[helper.length][helper.length];
    for (int end = 0; end < helper.length; end++) {
      for (int start = end - 1; start >= 0; start--) {
        dp[start][end] = Integer.MAX_VALUE;
        if (start == end - 1) {
          dp[start][end] = 0;
        } else {
          for (int k = end - 1; k >= start; k--) {
            dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k][end] + helper[end] - helper[start]);
          }
        }
      }
    }
    return dp[0][helper.length - 1];
  }
}