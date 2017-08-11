public class Solution {
  public int missing(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 1;
    }
    for (int i : array) {
      if (Math.abs(i) - 1 >= 0 && Math.abs(i) - 1 < array.length && array[Math.abs(i) - 1] > 0) {
        array[Math.abs(i) - 1] *= -1;
      }
    }
    int rst = 0;
    while (rst < array.length) {
      if (array[rst] > 0) {
        break;
      }
      rst++;
    }
    return rst + 1;
  }
}
