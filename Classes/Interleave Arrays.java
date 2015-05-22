public class Solution {
  public boolean canMerge(char[] a, char[] b, char[] c) {
    // write your solution here
    if (a.length + b.length != c.length) {
      return false;
    }
    boolean[][] dp = new boolean[a.length + 1][b.length + 1];
    dp[0][0] = true;
    for (int i = 1; i <= a.length; i++) {
      dp[i][0] = a[i - 1] == c[i - 1];
    }
    for (int j = 1; j <= b.length; j++) {
      dp[0][j] = b[j - 1] == c[j - 1];
    }
    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (!dp[i][j] && dp[i - 1][j] && a[i - 1] == c[i + j - 1]) {
          dp[i][j] = true;
        }
        if (!dp[i][j] && dp[i][j - 1] && b[j - 1] == c[i + j - 1]) {
          dp[i][j] = true;
        }
      }
    }
    return dp[a.length][b.length];
  }
}