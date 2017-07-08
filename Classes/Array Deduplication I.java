public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return array;
    }
    int index = 0;
    for (int i = 0; i < array.length; ++i) {
      if (i + 1 == array.length || array[i] != array[i + 1]) {
        array[index++] = array[i];
      }
    }
    int[] rst = new int[index];
    for (int i = 0; i < index; ++i) {
      rst[i] = array[i];
    }
    return rst;
  }
}
