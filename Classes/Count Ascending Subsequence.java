public class Solution {
  public int numIncreasingSubsequences(int[] a) {
    // Write your solution here
    final int MOD = 1000000007;

    long[] dp = new long[a.length];
    Arrays.fill(dp,  1L);
    for (int i = 1; i < a.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (a[j] < a[i]) {
          dp[i] = (dp[i] + dp[j]) % MOD;
        }
      }
    }
    long rst = 0;
    for (long l : dp) {
    	rst = (rst + l) % MOD;
    }
    return (int)rst;
  }
}
