public class Solution {
  public int[] rainbowSortIII(int[] array, int k) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int start = 0;
    for (int i = 1; i <= k; ++i) {
      start = sort(array, start, i);
    }
    return array;
  }
  private int sort(int[] colors, int start, int target) {
        int left = start;
        int cur = start;
        int right = colors.length - 1;
        while (cur <= right) {
            if (colors[cur] < target) {
                swap(colors, left++, cur++);
            } else if (colors[cur] == target) {
                cur++;
            } else {
                swap(colors, cur, right--);
            }
        }
        return left;
    }
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}