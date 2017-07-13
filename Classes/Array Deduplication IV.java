public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int index = 0;
    for (int i = 0; i < array.length; ++i) {
      if (index == 0 || array[index - 1] != array[i]) {
        array[index++] = array[i];
      } else {
        index--;
        while (i + 1 < array.length && array[i + 1] == array[i]) {
          i++;
        }
      }
    }
    int[] rst = new int[index];
    for (int i = 0; i < rst.length; ++i) {
      rst[i] = array[i];
    }
    return rst;
  }
}
