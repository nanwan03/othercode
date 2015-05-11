import java.util.*;

/**
 * Given a 2D array A[8][8] with all non negative integer numbers.
 * if we take a number a[i][j], then we cannot take its 8 neighboring cells.
 * How should we take these numbers to make their sum as large as possible.
 */
public class LargestSum {
	// Assumption: N == 8.
	static final int N = 8;

	// Assumption: N * N matrix.
	public int largestSum(int[][] matrix) {
		assert matrix != null && matrix.length == N && matrix[0].length == N;
		Integer[] configs = getValidConfigs();
		int[][] maxSum = new int[N][configs.length];
		int result = 0;
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < configs.length; j++) {
				if (i > 0) {
					for (int k = 0; k < configs.length; k++) {
						if (notConflict(configs[j], configs[k])) {
							maxSum[i][j] = Math.max(maxSum[i][j],
									maxSum[i - 1][k]);
						}
					}
				}
				maxSum[i][j] += getSum(matrix[i], configs[j]);
				result = Math.max(maxSum[i][j], result);
			}
		}
		return result;
	}
	
	private int getSum(int[] array, int config) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (((config >>> i) & 1) != 0)
			sum += array[i];
		}
		return sum;
	}

	private boolean notConflict(int c1, int c2) {
		return (c1 & c2) == 0 && ((c1 >>> 1) & c2) == 0
				&& ((c1 << 1) & c2) == 0;
	}

	private Integer[] getValidConfigs() {
		int temp = 0;
		ArrayList<Integer> configs = new ArrayList<Integer>();
		getValidConfigs(configs, 0, temp);
		return configs.toArray(new Integer[0]);
	}
	
	private void getValidConfigs(List<Integer> result, int index, int temp) {
		result.add(temp);
		for (int i = index; i < N; i++) {
			getValidConfigs(result, i + 2, (temp | (1 << i)));
		}
	}
	
	public static void main(String[] args) {
		LargestSum solution = new LargestSum();
		
		int[][] matrix = {
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1}
		};
		System.out.println(solution.largestSum(matrix));
	}
}
