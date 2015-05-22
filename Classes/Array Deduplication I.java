public class Solution {
  public int dedup(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int tail = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] != array[i - 1]) {
        array[++tail] = array[i];
      }
    }
    return ++tail;
  }
}