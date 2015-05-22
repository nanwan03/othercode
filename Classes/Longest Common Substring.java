public class Solution {
  public String longestCommon(String s, String t) {
    // write your solution here
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
      return "";
    }
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    int longest = 0;
    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j <= t.length(); j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
            longest = Math.max(longest, dp[i][j]);
          }
        }
      }
    }
    if (longest == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = s.length(); i >= 0; i--) {
      for (int j = t.length(); j >= 0; j--) {
        if (dp[i][j] == longest) {
          sb.append(s.charAt(i - 1));
          longest--;
          break;
        }
      }
      if (longest == 0) {
        break;
      }
    }
    return sb.reverse().toString();
  }
}