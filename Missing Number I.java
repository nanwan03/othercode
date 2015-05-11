public class Solution {
  public int missing(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 1;
    }
    for (int i = 0; i < array.length; i++) {
      while (array[i] > 0 && array[i] <= array.length && array[i] != i + 1) {
        int temp = array[array[i] - 1];
        if (temp == array[i]) {
          break;
        }
        array[array[i] - 1] = array[i];
        array[i] = temp;
      }
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] != i + 1) {
        return i + 1;
      }
    }
    return array.length + 1;
  }
}