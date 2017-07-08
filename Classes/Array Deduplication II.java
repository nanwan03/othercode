public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 2) {
      return array;
    }
    int index = 0;
    int dep = 0;
    for (int i = 0; i < array.length; ++i) {
      if (i + 1 == array.length || array[i] != array[i + 1]) {
        dep = 0;
        array[index++] = array[i];
      } else if (dep == 0) {
        dep++;
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
