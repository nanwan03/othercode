/**
 * Given a rope with integer-length n,
 * how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1],
 * in order to get the maximal product of p[0]*p[1]* ... *p[m-1]?
 * m is determined by you and must be greater than 0 (at least one cut must be made).
 */
public class CuttingRope {

	public int maxCut(int n) {
		assert n > 1;
		int[] maxCut = new int[n + 1];
		maxCut[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				// since we need at least one cut, the smaller part of the cut
				// is in range of [1, i / 2], for each of the values in this range,
				// we need to know that is the maximal product.
				// Two opetions, either we do not cut the i - j, or we cut the i - j,
				// So we have to pick the maximal value of maxCut[i - j] and i - j.
				maxCut[i] = Math.max(maxCut[i], j * Math.max(maxCut[i - j], i - j));
			}
		}
		return maxCut[n];
	}

	public static void main(String[] args) {
		CuttingRope solution = new CuttingRope();
		
		int n = 2;
		System.out.println(solution.maxCut(n));

		n = 3;
		System.out.println(solution.maxCut(n));

		n = 4;
		System.out.println(solution.maxCut(n));
		
		n = 11;
		System.out.println(solution.maxCut(n));
	}
}
