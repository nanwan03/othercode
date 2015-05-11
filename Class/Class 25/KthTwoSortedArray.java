/**
 * Kth smallest element in two sorted array.
 */
public class KthTwoSortedArray {

	public int kth(int[] A, int[] B, int K) {
		assert A != null && B != null & K > 0 && K <= A.length + B.length;
		return kth(A, 0, A.length - 1, B, 0, B.length - 1, K);
	}
	
	public int kth(int[] A, int aLeft, int aRight, int[] B, int bLeft, int bRight, int K) {
		int aLen = aRight - aLeft + 1;
		int bLen = bRight - bLeft + 1;
		if (aLen > bLen) {
			return kth(B, bLeft, bRight, A, aLeft, aRight, K);
		}
		if (aLen == 0) {
			return B[bLeft + K - 1];
		}
		if (K == 1) {
			return Math.min(A[aLeft], B[bRight]);
		}
		int k1 = Math.min(aLen, K / 2);
		int k2 = K - k1;
		if (A[aLeft + k1 - 1] < B[bLeft + k2 - 1]) {
			return kth(A, aLeft + k1, aRight, B, bLeft, bLeft + k2 - 1, K - k1);
		} else {
			return kth(A, aLeft, aLeft + k1 -1, B, bLeft + k2, bRight, K - k2);
		}
	}

	public int kthI(int[] A, int[] B, int K) {
		assert A != null && B != null & K > 0 && K <= A.length + B.length;
		if (A.length == 0) {
			return B[K - 1];
		} else if (B.length == 0) {
			return A[K - 1];
		}
		return kthI(A, Math.max(0, B.length - K - 1), Math.min(A.length - 1, K - 1), B, K);
	}
	
	public int kthI(int[] A, int left, int right, int[] B, int K) {
		if (left > right) {
			return kthI(B, Math.max(0, A.length - K - 1), Math.min(B.length - 1, K - 1), A, K);
		}
		int aMid = left + (right - left) / 2;
		int bMid = K - aMid - 1;
		if (bMid - 1 >= 0 && B[bMid - 1] > A[aMid]) {
			return kthI(A, aMid + 1, right, B, K);
		} else if (bMid < B.length && B[bMid] < A[aMid]) {
			return kthI(A, left, aMid - 1, B, K);
		}
		return A[aMid];
	}
	
	public int kthII(int[] A, int[]B, int K) {
		assert A != null && B != null & K > 0 && K <= A.length + B.length;
		return kthII(A, 0, B, 0, K);
	}
	
	public int kthII(int[] A, int aLeft, int[] B, int bLeft, int K) {
		if (aLeft >= A.length) {
			return B[bLeft + K - 1];
		} else if (bLeft >= B.length) {
			return A[aLeft + K - 1];
		}
		if (K == 1) {
			return Math.min(A[aLeft], B[bLeft]);
		}
		int aMid = aLeft + K / 2 - 1;
		int bMid = bLeft + K / 2 - 1;
		int aValue = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
		int bValue = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
		if (aValue < bValue) {
			return kthII(A, aMid + 1, B, bLeft, K - K / 2);
		} else {
			return kthII(A, aLeft, B, bMid + 1, K - K / 2);
		}
	}

	public static void main(String[] args) {
		KthTwoSortedArray solution = new KthTwoSortedArray();
		
		int[] A = {};
		int[] B = {1, 2, 3, 4};
		int K = 3;
		System.out.println(solution.kth(A, B, K));
		System.out.println(solution.kthI(A, B, K));
		System.out.println(solution.kthII(A, B, K));
		
		A = new int[] {1};
		B = new int[] {2};
		K = 2;
		System.out.println(solution.kth(A, B, K));
		System.out.println(solution.kthI(A, B, K));
		System.out.println(solution.kthII(A, B, K));
		
		A = new int[] {1, 2};
		B = new int[] {2, 3, 4, 5};
		K = 4;
		System.out.println(solution.kth(A, B, K));
		System.out.println(solution.kthI(A, B, K));
		System.out.println(solution.kthII(A, B, K));
	}
}
