
public class Solution {
  public int longestBitonic(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int size = array.length;
    int[] dpL = new int[size];
    int[] dpR = new int[size];
    int[] left = new int[size];
    int[] right = new int[size];
    int rstL = 0;
    int rstR = 0;
    for (int i = 0; i < size; ++i) {
      int index = Arrays.binarySearch(dpL, 0, rstL, array[i]);
      if (index < 0) {
        index = -(index + 1);
      }
      dpL[index] = array[i];
      if (index == rstL) {
        rstL++;
      }
      left[i] = rstL;
      
      index = Arrays.binarySearch(dpR, 0, rstR, array[size - 1 - i]);
      if (index < 0) {
        index = -(index + 1);
      }
      dpR[index] = array[size - 1 - i];
      if (index == rstR) {
        rstR++;
      }
      right[size - 1 - i] = rstR;
    }

    int rst = 0;
    for (int i = 0; i < size; ++i) {
      rst = Math.max(rst, left[i] + right[i] - 1);
    }
    return rst;
  }
}
