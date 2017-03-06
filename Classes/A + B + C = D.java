public class Solution {
  public boolean exist(int[] array) {
    // Write your solution here.
    Arrays.sort(array);
    for (int i = array.length - 1; i >= 3; --i) {
      boolean flag = helper(array, array[i], i - 1);
      if (flag) {
        return true;
      }
    }
    return false;
  }
  private boolean helper(int[] array, int target, int tail) {
    for (int i = 0; i <= tail; i++) {
      if (i != 0 && array[i] == array[i - 1]) {
        continue;
      }
      int left = i + 1;
			int right = tail;
			while (left < right) {
				int sum = array[left] + array[right] + array[i];
				if (sum == target) {
					return true;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
    }
    return false;
  }
}
