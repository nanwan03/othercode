public class Solution {
  public int largestSum(int[] array) {
    // write your solution here
    int max = Integer.MIN_VALUE;
    int maxSoFar = Integer.MIN_VALUE;
    for (int i : array) {
      maxSoFar = Math.max(maxSoFar, 0) + i;
      max = Math.max(max, maxSoFar);
    }
    return max;
  }
}