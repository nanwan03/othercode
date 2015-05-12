public class Solution {
  public int percentile95(List<Integer> lengths) {
    // write your solution here
    int[] count = new int[4096];
		for (int length : lengths) {
			count[length]++;
		}
		int sum = 0;
		int result = 4096;
		while (sum <= lengths.size() * 0.05) {
			sum += count[--result];
		}
		return result;
  }
}