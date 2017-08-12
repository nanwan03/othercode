
public class Solution {
  public int leastInsertion(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return 0;
    }
    int size = input.length();
    int[][] dp = new int[size][size];
    for (int end = 0; end < size; ++end) {
      for (int start = end - 1; start >= 0; --start) {
        if (input.charAt(start) == input.charAt(end)) {
          dp[start][end] = dp[start + 1][end - 1];
        } else {
          dp[start][end] = Math.min(dp[start][end - 1], dp[start + 1][end]) + 1;
        }
      }
    }
    return dp[0][size - 1];
  }
}
