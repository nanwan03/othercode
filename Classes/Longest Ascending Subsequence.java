public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    int[] dp = new int[array.length];
    int rst = 0;
    for (int i : array) {
      int index = Arrays.binarySearch(dp, 0, rst, i);
      if (index < 0) {
        index = -(index + 1);
      }
      dp[index] = i;
      if (index == rst) {
        rst++;
      }
    }
    return rst;
  }
}
