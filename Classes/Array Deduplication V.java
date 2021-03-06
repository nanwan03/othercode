public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int tail = 0;
    int dup = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] != array[i - 1]) {
        array[++tail] = array[i];
        dup = 1;
      } else if (dup == 1) {
        array[++tail] = array[i];
        dup = 0;
      }
    }
    int[] rst = new int[tail + 1];
    for (int i = 0; i <= tail; ++i) {
      rst[i] = array[i];
    }
    return rst;
  }
}
