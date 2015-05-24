public class Solution {
  public int[] maxSum(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return new int[0];
    }
    
    int temp = 0;
    int max1 = 0;
    int maxIndex1 = 0;
    int max2 = 0;
    int maxIndex2 = 0;
    
    for (int i = 0; i < array.length; i++) {
      temp = array[i] - i;
      if (temp > max1) {
        max1 = temp;
        maxIndex1 = i;
      }
      temp = array[i] + i;
      if (temp > max2) {
        max2 = temp;
        maxIndex2 = i;
      }
    }
    
    int[] rst = new int[2];
    rst[0] = Math.min(maxIndex1, maxIndex2);
    rst[1] = Math.max(maxIndex1, maxIndex2);
    return rst;
  }
}