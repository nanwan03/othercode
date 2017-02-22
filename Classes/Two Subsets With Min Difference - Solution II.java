public class Solution {
  /*
   * Works only when input array has no negative elements.
   * Doesn't have limitation on the size of subset
   */
  public int minDifference(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    boolean[][] dp = new boolean[sum + 1][array.length + 1];
    for (int i = 0; i <= array.length; i++) {
      dp[0][i] = true;
    }
    for (int i = 1; i <= sum; i++) {
      dp[i][0] = false;
    }
    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= array.length; j++) {
        dp[i][j] = dp[i][j - 1];
        if (i >= array[j - 1]) {
          dp[i][j] = dp[i][j] || dp[i - array[j - 1]][j - 1];
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= array.length; j++) {
        if (dp[i][j]) {
          if (Math.abs(sum - i * 2) < min) {
            min = Math.abs(sum - i * 2);
          }
        }
      }
    }
    return min;
  }
}