import java.util.*;

/**
 * Find the kth smallest number in a two-dimensional array.
 * The elements in each row of the array are sorted.
 * The elements in each column of the array are also sorted.
 * 
 */
public class KthSmallestInMatrix {

	private static class Entry {
		int xIndex;
		int yIndex;
		int value;
		
		public Entry(int xIndex, int yIndex, int value) {
			this.xIndex = xIndex;
			this.yIndex = yIndex;
			this.value = value;
		}
		// this method needs to be overridden to be used by HashSet.
		// we need to guarantee two things:
		// 1). for any equal Entry objects, their hashCode should be same.
		// 2). provide as less conflicts as possible for not equal objects.
		@Override
		public int hashCode() {
			return xIndex * 101 + yIndex;
		}
		
		// this method needs to be overridden to be used by HashSet.
		// if two Entry objects have the same xIndex and yIndex,
		// we think them equal.
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Entry)) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			Entry another = (Entry) obj;
			return this.xIndex == another.xIndex
					&& this.yIndex == another.yIndex;
		}
	}

	public int kth(final int[][] matrix, int k) {
		sanityCheck(matrix, k);
		int len = matrix.length;
		PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k,
			// minHeap comparator for Entry class.
			// use a minHeap because we need to expand
			// the smallest one every time.
			new Comparator<Entry>() {
				public int compare(Entry arg1, Entry arg2) {
					return arg1.value - arg2.value;
				}
			});
		// use a HashSet to mark the visited Entries,
		// if the Entry is in the set, means it is in the heap.
		Set<Entry> visited = new HashSet<Entry>();
		
		int result = Integer.MIN_VALUE;
		Entry start = new Entry(0, 0, matrix[0][0]);
		minHeap.offer(start);
		visited.add(start);
		while (k > 0) {
			Entry current = minHeap.poll();
			result = current.value;
			// there are two neighbors need to be examined.
			// if the neighbor has been visited, means it is already in the heap,
			// we do not need to do anything;
			// if the neighbor has not been visited,
			// we need to insert it into the heap.
			if (current.xIndex + 1 < len) {
				Entry right = new Entry(current.xIndex + 1, current.yIndex,
						matrix[current.xIndex + 1][current.yIndex]);
				if (!visited.contains(right)) {
					minHeap.offer(right);
					visited.add(right);
				}
			}
			if (current.yIndex + 1 < len) {
				Entry down = new Entry(current.xIndex, current.yIndex + 1,
						matrix[current.xIndex][current.yIndex + 1]);
				if (!visited.contains(down)) {
					minHeap.offer(down);
					visited.add(down);
				}
			}
			k--;
		}
		return result;
	}
	
	// usually for this kind of problem, we do not need to have a complete
	// sanity check, we can confirm with interviewer for assumptions that
	// the input is already clean.
	private void sanityCheck(int[][] matrix, int k) {
		assert matrix != null && matrix.length > 0;
		int len = matrix.length;
		assert k >= 1 && k <= len * len;
		for (int index = 0; index < len; index++) {
			assert matrix[index] != null && matrix[index].length == len; 
		}
	}
	
	public static void main(String[] args) {
		KthSmallestInMatrix solution = new KthSmallestInMatrix();
		
		int[][] matrix = {
				{1, 2, 7, 8}, 
				{3, 5, 9, 13}, 
				{4, 6, 10, 14}, 
				{6, 8, 12, 15}
		};
		for (int k = 1; k <= 10; k++) {
			System.out.println(solution.kth(matrix, k));
		}
	}
}
