public class Solution {
  public int minJump(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] dp = new int[array.length];
    dp[0] = 0;
    for (int i = 1; i < array.length; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i && dp[i] == Integer.MAX_VALUE; j++) {
        if (dp[j] != Integer.MAX_VALUE && array[j] >= i - j) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[array.length - 1] == Integer.MAX_VALUE ? -1 : dp[array.length - 1];
  }
}