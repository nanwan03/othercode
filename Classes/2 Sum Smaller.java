
public class Solution {
  public int smallerPairs(int[] array, int target) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    Arrays.sort(array);
    int left = 0;
    int right = array.length - 1;
    int rst = 0;
    while (left < right) {
      int sum = array[left] + array[right];
      if (sum >= target) {
        right--;
      } else {
        rst += right - left;
        left++;
      }
    }
    return rst;
  }
}
