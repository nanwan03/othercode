public class Solution {
  public int minCuts(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return 0;
    }
    boolean[][] isPa = new boolean[input.length()][input.length()];
    int[] dp = new int[input.length()];
    int size = input.length();
    for (int i = 0; i < size; i++) {
      dp[i] = i;
      for (int j = i; j >= 0; j--) {
        if (input.charAt(i) == input.charAt(j) &&
            (i - j < 2 || isPa[j + 1][i - 1])) {
            isPa[j][i] = true;
            dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
        } else {
          isPa[j][i] = false;
        }
      }
    }
    return dp[size - 1];
  }
}