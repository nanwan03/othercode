public class Solution {
  public int editDistance(String one, String two) {
    // write your solution here
    if (one.length() == 0 || two.length() == 0) {
      return Math.max(one.length(), two.length());
    }
    int[][] dp = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i <= one.length(); i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= two.length(); j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= one.length(); i++) {
      for (int j = 1; j <= two.length(); j++) {
        if (one.charAt(i - 1) == two.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
      }
    }
    return dp[one.length()][two.length()];
  }
}