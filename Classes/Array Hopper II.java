public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return -1;
    }
    int start = 0;
    int maxCover = 0;
    int step = 0;
    while (maxCover < array.length - 1) {
      step++;
      int max = 0;
      for (int i = start; i <= maxCover; ++i) {
        max = Math.max(max, i + array[i]);
      }
      if (max <= maxCover) {
        return -1;
      }
      start = maxCover + 1;
      maxCover = Math.max(max, maxCover);
      if (maxCover >= array.length - 1) {
        break;
      }
    }
    return step;
  }
}
