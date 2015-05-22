public class Solution {
  public void shuffle(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return;
    }
    Random r = new Random();
    for (int i = 0; i < array.length; i++) {
      swap (array, i, i + r.nextInt(array.length - i));
    }
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}