public class Solution {
  public int maxProduct(int n) {
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i / 2; j++) {
        dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
      }
    }
    return dp[n];
  }
}