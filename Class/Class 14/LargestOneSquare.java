/**
 * Determine the edge length of the largest square of 1¡¯s
 * in a given binary matrix.
 */
public class LargestOneSquare {

	// Assumption: the matrix is n * n, and n > 0.
	public int largest(int[][] matrix) {
		assert matrix != null;
		int len = matrix.length;
		// to record the largest square with the bottom right corner's
		// coordinate as i, j for all i, j in [0, len - 1].
		int[][] largest = new int[len][len];
		// to get the largest square in one pass, we need to record and
		// update the global largest square, it is initialized to 0 at
		// first place.
		int result = 0;
		for (int row = 0; row < len; row++) {
			for (int col = 0; col < len; col++) {
				if (matrix[row][col] == 0) {
					largest[row][col] = 0;
				} else if (row == 0 || col == 0) {
					// for all the border cell with value 1, the largest square is 1.
					largest[row][col] = 1;
				} else {
					largest[row][col] = Math.min(largest[row - 1][col - 1],
							Math.min(largest[row - 1][col], largest[row][col - 1])) + 1;
				}
				result = Math.max(result, largest[row][col]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LargestOneSquare solution = new LargestOneSquare();
		
		int[][] matrix = new int[][] {
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 0},
				{1, 1, 0, 0},
		};
		System.out.println(solution.largest(matrix));
	}
}
