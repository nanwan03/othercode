import java.util.*;
/**
 * Given two sorted arrays A and B, with their sizes to be m and n, respectively.
 * We can pick one element a from A and the other element b from B,
 * and their sum s is defined to be s = a + b.
 * How to find k-th smallest s from all possible values of s.
 */
public class KthSumTwoSortedArray {
	// class to hold the indices of the two arrays.
	private static class Indices {
		int indexOne;
		int indexTwo;
		Indices(int indexOne, int indexTwo) {
			this.indexOne = indexOne;
			this.indexTwo = indexTwo;
		}
	}
	
	public int kthSum(final int[] arrayOne, final int[] arrayTwo, int k) {
		assert arrayOne != null && arrayTwo != null;
		assert arrayOne.length != 0 && arrayTwo.length != 0;
		assert k <= arrayOne.length * arrayTwo.length;
		
		int lengthOne = arrayOne.length;
		int lengthTwo = arrayTwo.length;
		
		// use an array to store the last visited index in arrayTwo
		// for each of the index in arrayOne, we can use this as the
		// hashset to maintain all the visited indices.
		int[] latestIndex = new int[lengthOne];
		// initialize to -1, this is a must.
		Arrays.fill(latestIndex, -1);
		
		Queue<Indices> minHeap = new PriorityQueue<Indices>(k, 
			new Comparator<Indices>() {
				@Override
				public int compare(Indices i1, Indices i2) {
					return arrayOne[i1.indexOne] + arrayTwo[i1.indexTwo] - arrayOne[i2.indexOne] - arrayTwo[i2.indexTwo];
				}
			});
		minHeap.offer(new Indices(0, 0));
		latestIndex[0] = 0;
		int result = Integer.MIN_VALUE;
		while (k > 0) {
			Indices indices = minHeap.poll();
			int indexOne = indices.indexOne;
			int indexTwo = indices.indexTwo;
			result = arrayOne[indexOne] + arrayTwo[indexTwo];
			if (indexTwo + 1 < lengthTwo && latestIndex[indexOne] == indexTwo) {
				// offer only if we have not visited the indices(indexOne, indexTwo + 1).
				minHeap.offer(new Indices(indexOne, indexTwo + 1));
				// update the latest index for indexOne to indexTwo + 1.
				latestIndex[indexOne] = indexTwo + 1;
			}
			if (indexOne + 1 < lengthOne && latestIndex[indexOne + 1] == indexTwo - 1) {
				// offer only if we have not visited the indices(indexOne + 1, indexTwo).
				minHeap.offer(new Indices(indexOne + 1, indexTwo));
				// update the latest index for indexOne + 1 to indexTwo.
				latestIndex[indexOne + 1] = indexTwo;
			}
			k--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		KthSumTwoSortedArray solution = new KthSumTwoSortedArray();
		
		int[] arrayOne = new int[] {1, 2, 3};
		int[] arrayTwo = new int[] {1, 2, 3, 4};
		int k = 5;
		System.out.println(solution.kthSum(arrayOne, arrayTwo, k));
		
		k = 8;
		System.out.println(solution.kthSum(arrayOne, arrayTwo, k));
	}
}
