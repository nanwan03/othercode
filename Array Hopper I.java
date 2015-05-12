public class Solution {
  public boolean canJump(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return true;
    }
    int maxCover = 0;
    for (int i = 0; i <= maxCover && i < array.length; i++) {
      maxCover = Math.max(maxCover, i + array[i]);
    }
    return maxCover >= array.length - 1;
  }
}