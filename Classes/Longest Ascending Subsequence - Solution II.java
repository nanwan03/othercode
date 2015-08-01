public class Solution {
  public int longest(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] dp = new int[array.length];
    Arrays.fill(dp, 1);
    int longest = 1;
    for (int i = 0; i < array.length; ++i) {
      for (int j = i + 1; j < array.length; ++j) {
        if (array[j] > array[i]) {
          dp[j] = Math.max(dp[j], dp[i] + 1);
          longest = Math.max(longest, dp[j]);
        }
      }
    }
    return longest;
  }
}