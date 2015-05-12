public class Solution {
  public int maxProfit(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int rst = 0;
    for (int i = 1; i < array.length; i ++) {
      if (array[i] > array[i - 1]) {
        rst += array[i] - array[i - 1];
      }
    }
    return rst;
  }
}