public class Solution {
  public int minCost(int[] cuts, int length) {
    // Write your solution here.
    if (cuts == null || cuts.length == 0) {
      return 0;
    }
    int[] helper = new int[cuts.length + 2];
    helper[0] = 0;
    helper[helper.length - 1] = length;
    for (int i = 0; i < cuts.length; ++i) {
      helper[i + 1] = cuts[i];
    }
    int size = helper.length;
    int[][] dp = new int[size][size];
    for (int end = 0; end < size; ++end) {
      for (int start = end; start >= 0; --start) {
        dp[start][end] = (start == end || start == end - 1) ? 0 : Integer.MAX_VALUE / 2;
        for (int k = end; k >= start; --k) {
          dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k][end] + helper[end] - helper[start]);
        }
      }
    }
    return dp[0][size - 1];
  }
}
