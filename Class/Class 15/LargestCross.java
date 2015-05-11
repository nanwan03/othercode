/**
 * Given a Matrix that contains only 1s and 0s,
 * find the largest cross which contains only 1s,
 * return the length of the arm.
 */
public class LargestCross {

	// Assumption:
	// 1. matrix is not empty, row > 0 & col > 0
	// 2. all the matrix's rows has same length
	public int largest(int[][] matrix) {
		assert matrix != null;
		int rows = matrix.length;
		int cols = matrix[0].length;
		return merge(longestUpLeft(matrix, rows, cols),
				longestDownRight(matrix, rows, cols));
	}
	
	private int[][] longestUpLeft(int[][] matrix, int rows, int cols) {
		int[][] longestUp = new int[rows][cols];
		int[][] longestLeft = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					longestUp[i][j] = getNumber(i - 1, j, longestUp) + 1;
					longestLeft[i][j] = getNumber(i, j - 1, longestLeft) + 1;
				}
			}
		}
		merge(longestUp, longestLeft);
		return longestUp;
	}
	
	private int[][] longestDownRight(int[][] matrix, int rows, int cols) {
		int[][] longestDown = new int[rows][cols];
		int[][] longestRight = new int[rows][cols];
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					longestDown[i][j] = getNumber(i + 1, j, longestDown) + 1;
					longestRight[i][j] = getNumber(i, j + 1, longestRight) + 1;
				}
			}
		}
		merge(longestDown, longestRight);
		return longestDown;
	}
	
	private int getNumber(int row, int col, int[][] longest) {
		if (row < 0 || row >= longest.length) {
			return 0;
		} else if (col < 0 || col >= longest[0].length) {
			return 0;
		}
		return longest[row][col];
	}
	
	// update matrix1's elements to the min value of the two values
	// in the same position of matrix1 and matrix2
	// and return the max value of matrix1 after merging.
	private int merge(int[][] matrix1, int[][] matrix2) {
		int max = 0;
		for (int row = 0; row < matrix1.length; row++) {
			for (int col = 0; col < matrix1[0].length; col++) {
				matrix1[row][col] = Math.min(matrix1[row][col], matrix2[row][col]);
				max = Math.max(max, matrix1[row][col]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		LargestCross solution = new LargestCross();
		
		int[][] matrix = new int[][] {
				{1, 0, 1, 0, 1},
				{0, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 0, 1, 1, 1}
		};
		System.out.println(solution.largest(matrix));
	}
}
