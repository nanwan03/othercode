public class Solution {
  public void rainbowSort(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return;
    }
    int left = 0;
    int right = array.length - 1;
    int cur = 0;
    while (cur <= right) {
      if (array[cur] == -1) {
        swap(array, cur++, left++);
      } else if (array[cur] == 0) {
        cur++;
      } else {
        swap(array, cur, right--);
      }
    }
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}