public class Solution {
  public int missing(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 1;
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] != i + 1) {
        return i + 1;
      }
    }
    return array.length + 1;
  }
}