public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return -1;
    }
    int maxCover = 0;
    int step = 0;
    for (int i = 0; maxCover < array.length - 1 && i < array.length;) {
      int max = 0;
      step++;
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
