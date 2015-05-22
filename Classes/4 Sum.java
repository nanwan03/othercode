public class Solution {
  public boolean exist(int[] array, int target) {
        if (array == null || array.length < 4) {
            return false;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = array.length - 1;
                while (left < right) {
                    int sum = array[i] + array[j] + array[left] + array[right];
                    if (sum == target) {
                        return true;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
  }
}