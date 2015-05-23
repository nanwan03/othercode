public class Solution {
  public int numOfTriangles(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
            return 0;
    }
    Arrays.sort(array);
    int rst = 0;
    for (int k = array.length - 1; k > 1; --k) {
        int i = 0;
        int j = k - 1;
        while (i < j) {
            if (array[i] + array[j] <= array[k]) {
                i++;
            } else {
                rst += j - i;
                j--;
            }
        }
    }
    return rst;
  }
}