public class Solution {
  public int[] dedup(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return array;
    }
    int tail = -1;
    for (int i = 0; i < array.length; i++) {
      int num = 1;
      while (i < array.length -1 && array[i] == array[i + 1]) {
        i++;
        num++;
      }
      if (num == 1) {
        array[++tail] = array[i];
      }
    }
    int[] rst = new int[++tail];
    for (int i = 0; i < tail; i++) {
      rst[i] = array[i];
    }
    return rst;
  }
}