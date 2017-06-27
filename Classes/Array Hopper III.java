public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int maxCover = 0;
    int step = 0;
    for (int i = 0; maxCover <= array.length - 1 && i < array.length;) {
      step++;
      int max = 0;
      for (int j = i; j <= maxCover; ++j) {
        max = Math.max(max, j + array[j]);
      }
      if (max <= maxCover) {
        return -1;
      }
      i = maxCover + 1;
      maxCover = max;
    }
    return step;
  }
}
