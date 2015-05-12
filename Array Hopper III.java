public class Solution {
  public int minJump(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int start = 0;
    int maxCover = 0;
    int step = 0;
    while (maxCover < array.length) {
      int max = 0;
      step++;
      for (int i = start; i <= maxCover; i++) {
        if (array[i] + i >= array.length) {
          return step;
        }
        max = Math.max(max, array[i] + i);
      }
      if (max <= maxCover) {
        return -1;
      }
      start = maxCover + 1;
      maxCover = max;
    }
    return step;
  }
}