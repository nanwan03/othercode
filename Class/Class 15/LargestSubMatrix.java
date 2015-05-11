/**
 * Given a Matrix of integers (positive & negative numbers & 0s),
 * find the submatrix with the largest sum, return the sum.
 */
public class LargestSubMatrix {

	// Assumption:
	// 1. matrix is not empty, row > 0 & col > 0
	// 2. all the matrix's rows has same length
	public int largest(int[][] matrix) {
		assert matrix != null;
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			int[] array = new int[matrix[0].length];
			for (int j = i; j < matrix.length; j++) {
				addArray(array, matrix[j]);
				int curLargest = largest(array);
				largest = Math.max(largest, curLargest);
			}
		}
		return largest;
	}
	
	private void addArray(int[] array, int[] addition) {
		for (int i = 0; i < array.length; i++) {
			array[i] += addition[i];
		}
	}
	
	private int largest(int[] array) {
		int largest = Integer.MIN_VALUE;
		int curLargest = 0;
		for (int i = 0; i < array.length; i++) {
			curLargest = Math.max(curLargest + array[i], array[i]);
			largest = Math.max(largest, curLargest);
		}
		return largest;
	}
	
	public static void main(String[] args) {
		LargestSubMatrix solution = new LargestSubMatrix();
		
		int[][] matrix = new int[][] {
				{ 1,  2, -1, -4, -20},
				{-8, -3,  4,  2,   1},
				{ 3,  8, 10,  1,   3},
				{-4, -1,  1,  7,  -6}
		};
		System.out.println(solution.largest(matrix));
	}
}
