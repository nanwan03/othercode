public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // write your solution here
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (array == null || array.length == 0) {
      return rst;
    }
    Arrays.sort(array);
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
    	int sum = array[left] + array[right];
    	if (sum == target) {
    		List<Integer> items = new ArrayList<Integer>();
    		items.add(array[left]);
    		items.add(array[right]);
    		rst.add(items);
    		left++;
    	} else if (sum < target) {
    		left++;
    	} else {
    		right--;
    	}
    	while (left > 0 && array[left - 1] == array[left]) {
    		left++;
    	}
    	while (right < array.length - 1 && array[right + 1] == array[right]) {
    		right--;
    	}
    }
    return rst;
  }
}