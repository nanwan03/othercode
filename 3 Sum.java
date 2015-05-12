public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // write your solution here
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (array == null || array.length < 3) {
      return rst;
    }
    Arrays.sort(array);
    int length = array.length;
    for (int i = 0; i < length - 2; i++) {
      if (i != 0 && array[i] == array[i - 1]) {
        continue;
      }
      int left = i + 1;
			int right = length - 1;
			while (left < right) {
				int sum = array[left] + array[right] + array[i];
				if (sum == target) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(array[i]);
					tmp.add(array[left]);
					tmp.add(array[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && array[left] == array[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && array[right] == array[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
    }
    return rst;
  }
}