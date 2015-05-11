/**
 * There are n piles of stones in a row£¬
 * The piles have a1, a2, ..., an stones respectively.
 * You can merge two adjacent piles of stones,
 * paying a cost which is equal to the number of stones
 * in the resulting pile.
 * Find the minimum cost of merging all the stones to
 * a single pile.
 */
public class MergeStone {

	public int minCost(int[] stones) {
		assert stones != null;
		if (stones.length == 0) {
			return 0;
		}
		int length = stones.length;
		// minCost to record the min cost of merging the stones at subarray [i, j]
		// subSum to record the sum of subarray [i, j]
		int[][] minCost = new int[length][length];
		int[][] subSum = new int[length][length];
		for (int end = 0; end < length; end++) {
			for (int start = end; start >= 0; start--) {
				if (start == end) {
					// if start == end, we do not need to merge, the cost is 0.
					subSum[start][end] = stones[start];
					minCost[start][end] = 0;
				} else {
					// else, we need to find the min cost of the next cut at any indices
					// between [start, end - 1],
					// minCost[start][end] = min(minCost[start][mid] + minCost[mid + 1][end] + subSsum[start][end]),
					// for any mid in [start, end - 1]
					subSum[start][end] = subSum[start][end - 1] + stones[end];
					minCost[start][end] = Integer.MAX_VALUE;
					for (int mid = end - 1; mid >= start; mid--) {
						minCost[start][end] = Math.min(minCost[start][end],
							minCost[start][mid] + minCost[mid + 1][end] + subSum[start][end]);
					}
				}
			}
		}
		return minCost[0][length - 1];
	}
	public static void main(String[] args) {
		MergeStone solution = new MergeStone();
		
		int[] stones = new int[0];
		System.out.println(solution.minCost(stones));
		
		stones = new int[] {1};
		System.out.println(solution.minCost(stones));
		
		stones = new int[] {4, 3, 3, 4};
		System.out.println(solution.minCost(stones));
		
		stones = new int[] {13, 7, 8};
		System.out.println(solution.minCost(stones));
	}
}
