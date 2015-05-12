public class Solution {
  public int maxTrapped(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
            return 0;
        }
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int left = 0;
        int right = array.length - 1;
        int rst = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, array[left]);
            rightMax = Math.max(rightMax, array[right]);
            if (leftMax < rightMax) {
                rst += leftMax - array[left];
                left++;
            } else {
                rst += rightMax - array[right];
                right--;
            }
        }
        return rst;
  }
}