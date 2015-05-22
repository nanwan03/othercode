public class Solution {
  public int longest(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int longest = 1;
    int tempLongest = 1;
    for (int i = 0; i < array.length - 1; i ++) {
      if (array[i] < array[i + 1]) {
        tempLongest++;
        longest = Math.max(longest, tempLongest);
      } else {
        tempLongest = 1;
      }
    }
    return longest;
  }
}