public class Solution {
  public int minCost(int[] stones) {
    // Write your solution here.
    if (stones == null || stones.length == 0) {
      return 0;
    }
    int size = stones.length;
    int[][] dp = new int[size][size];
    int[][] sum = new int[size][size];
    for (int end = 0; end < size; ++end) {
      for (int start = end; start >= 0; --start) {
        sum[start][end] = start == end ? stones[start] : sum[start][end - 1] + stones[end];
        dp[start][end] = start == end ? 0 : Integer.MAX_VALUE;
        for (int k = end - 1; k >= start; --k) {
          dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end] + sum[start][end]);
        }
      }
    }
    return dp[0][size - 1];
  }
}
