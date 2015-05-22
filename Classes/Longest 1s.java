public class Solution {
  public int longest(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int longest = 0;
    int longestSoFar = 0;
    for (int i : array) {
      if (i == 1) {
        longestSoFar++;
        longest = Math.max(longest, longestSoFar);
      } else {
        longestSoFar = 0;
      }
    }
    return longest;
  }
}