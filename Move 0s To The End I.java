public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int left = 0;
    int right = array.length - 1;
    int cur = left;
    while (cur <= right) {
      if (array[cur] == 0) {
        swap(array, cur, right--);
      } else {
        cur++;
      }
    }
    return array;
  }    
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}