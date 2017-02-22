public class Solution {
  public boolean canBreak(String input, String[] dict) {
    boolean[] dp = new boolean[input.length()];
    Set<String> set = new HashSet<String>(Arrays.asList(dict));
    dp[0] = true;
    for (int i = 0; i < input.length(); i++) {
      if (set.contains(input.substring(0, i + 1))) {
        dp[i] = true;
      } else {
        for (int j = 0; j < i && !dp[i]; j++) {
          if (dp[j] && set.contains(input.substring(j + 1, i + 1))) {
            dp[i] = true;
          }
        }
      }
    }
    return dp[input.length() - 1];
  }
}
