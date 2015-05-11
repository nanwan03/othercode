/**
 * There is a wood stick with length of L, we need to cut it into pieces,
 * and the cutting position is defined as an int array A, the positions are
 * guaranteed to be in ascending order in the rage of [1, L - 1].
 * The cost of each cut is the length of wood stick left. Determine the minimal
 * total cost to cut the stick into the defined pieces.
 * For Example,
 * A wood stick with length 10 and A = {2, 4, 7}
 * if we make first cut at 4, the cost of first cut is 10,
 * then we make the second cut at 2, the cost of second cut is 4
 * (the cut is made on the first 4 units of the stick)
 * then we make the third cut at 7, the cost of third cut is 6
 * (the cut is made on the last 6 units of the stick)
 * total cost = 10 + 4 + 6 = 20.
 */
public class CutWood {

	// Assumptions:
	// 1. length > 1
	// 2. cuts is not null or empty
	// 3. cuts is sorted in ascending order
	// 4. smallest element in cuts >= 1
	// 5. largest element in cuts < length
	// 6. no duplicate elements in cuts
	public int minCost(int length, int[] cuts) {
		int[] helper = new int[cuts.length + 2];
		// fill in the first and last element to make the problem easier to handle.
		helper[0] = 0;
		helper[helper.length - 1] = length;
		for (int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		int[][] minCost = new int[helper.length][helper.length];
		for (int end = 1; end < helper.length; end++) {
			for (int start = end - 1; start >= 0; start--) {
				minCost[start][end] = Integer.MAX_VALUE;
				if (start == end - 1) {
					minCost[start][end] = 0;
				} else {
					for (int k = start + 1; k < end; k++) {
						minCost[start][end] = Math.min(
								minCost[start][end],
								minCost[start][k] + minCost[k][end] + helper[end] - helper[start]);
					}
				}
			}
		}
		return minCost[0][minCost.length - 1];
	}
	
	public static void main(String[] args) {
		CutWood solution = new CutWood();
		int length = 10;
		int[] cuts = new int[] {2, 4, 7};
		System.out.println(solution.minCost(length, cuts));
		
		length = 14;
		cuts = new int[] {4, 7, 10};
		System.out.println(solution.minCost(length, cuts));
	}
}
