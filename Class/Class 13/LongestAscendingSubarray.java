/**
 * Given an unsorted array, find the length of the longest subarray in which
 * the numbers are in ascending order. 
 */
public class LongestAscendingSubarray {
	// O(n ^ 2) solution, for each index of the original array, find the
	// longest ascending subarray starting with that index.
	public int longestI(int[] array) {
		assert array != null;
		int longest = 0;
		for (int start = 0; start < array.length; start++) {
			int curLongest = 1;
			for (int i = start + 1; i < array.length; i++) {
				if (array[i] > array[i - 1]) {
					curLongest++;
				} else {
					break;
				}
			}
			longest = curLongest > longest ? curLongest : longest; 
		}
		return longest;
	}
	// O(n) solution, for each index of the original array, find the longest
	// ascending subarray ending with that index.
	public int longestII(int[] array) {
		assert array != null;
		if (array.length == 0) {
			return 0;
		}
		// the global longest subarray length
		int longest = 1;
		// the current longest subarray length
		int curLongest = 1;
		for (int i = 1; i < array.length; i++) {
			// if array[i] > array[i - 1], we can let curLongest++
			// else the current asceding subarray is ended and
			// we need to start with a new one.
			if (array[i] > array[i - 1]) {
				curLongest++;
				longest = curLongest > longest ? curLongest : longest;
			} else {
				curLongest = 1;
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubarray solution = new LongestAscendingSubarray();
		
		int[] array = new int[0];
		System.out.println(solution.longestI(array));
		System.out.println(solution.longestII(array));
		
		array = new int[] {1};
		System.out.println(solution.longestI(array));
		System.out.println(solution.longestII(array));
		
		array = new int[] {3, 3, 3};
		System.out.println(solution.longestI(array));
		System.out.println(solution.longestII(array));
		
		array = new int[] {3, 2, 1};
		System.out.println(solution.longestI(array));
		System.out.println(solution.longestII(array));
		
		array = new int[] {1, 2, 3, 4};
		System.out.println(solution.longestI(array));
		System.out.println(solution.longestII(array));
		
		array = new int[] {7, 2, 3, 1, 5, 8, 9};
		System.out.println(solution.longestI(array));
		System.out.println(solution.longestII(array));
	}
}
