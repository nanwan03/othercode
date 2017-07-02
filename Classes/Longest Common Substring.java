public class Solution {
  public String longestCommon(String s, String t) {
    // Write your solution here.
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
      return "";
    }
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    int longest = 0;
    int sIndex = -1;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
          if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
            if (dp[i][j] > longest) {
              longest = dp[i][j];
              sIndex = i;
            }
          }
      }
    }
    if (longest == 0) {
      return "";
    }
    
    return s.substring(sIndex - longest, sIndex);
  }
}
