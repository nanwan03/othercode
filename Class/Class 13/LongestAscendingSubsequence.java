/**
 * Given an unsorted array, find the length of the longest subsequence
 * in which the numbers are in ascending order.
 * Difference between subarray and subsequence:
 * In a subarray, the elements must be consecutive in the original array.
 * In a subsequence, the elements might not be consecutive in the original array,
 * but the order in the original array is preserved.
 */
public class LongestAscendingSubsequence {

	public int longest(int[] array) {
		assert array != null;
		if (array.length == 0) {
			return 0;
		}
		// record the longest ascending subsequence's length ending
		// at each of the indices.
		int[] longest = new int[array.length];
		// record the current longest ascending subsequence's length
		// so that we can do it in one pass.
		int longestSeq = 1;
		for (int i = 0; i < array.length; i++) {
			int curLongest = 0;
			// get the longest ascending subsequence that can be
			// ending at index i
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && longest[j] > curLongest) {
					curLongest = longest[j];
				}
			}
			longest[i] = curLongest + 1;
			// update the global longest if possible.
			longestSeq = longest[i] > longestSeq ? longest[i] : longestSeq;
		}
		return longestSeq;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubsequence solution = new LongestAscendingSubsequence();
		
		int[] array = new int[0];
		System.out.println(solution.longest(array));
		
		array = new int[] {1};
		System.out.println(solution.longest(array));
		
		array = new int[] {3, 3, 3};
		System.out.println(solution.longest(array));

		array = new int[] {3, 2, 1};
		System.out.println(solution.longest(array));

		array = new int[] {1, 2, 4, 3, 7, 6, 4, 5};
		System.out.println(solution.longest(array));
	}
}
