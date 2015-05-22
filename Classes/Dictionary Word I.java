public class Solution {
  public boolean canBreak(String input, Set<String> dict) {
    // write your solution here
    boolean[] dp = new boolean[input.length()];
    dp[0] = true;
    for (int i = 0; i < input.length(); i++) {
      if (dict.contains(input.substring(0, i + 1))) {
        dp[i] = true;
      } else {
        for (int j = 0; j < i && !dp[i]; j++) {
          if (dp[j] && dict.contains(input.substring(j + 1, i + 1))) {
            dp[i] = true;
          }
        }
      }
    }
    return dp[input.length() - 1];
  }
}