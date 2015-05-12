public class Solution {
  public int largest(int[] array) {
    if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int max = 0;
        while (left < right) {
            int volume = Math.min(array[left], array[right]) * (right - left);
            max  = Math.max(volume, max);
            if (array[left] < array[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
  }
}