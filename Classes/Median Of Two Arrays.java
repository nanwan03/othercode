public class Solution {
  public double median(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int length = a.length + b.length;
    if ((length & 0x01) == 0) {
        return (double)(findK(a, 0, b, 0, length / 2) + findK(a, 0, b, 0, length / 2 + 1)) / 2.0;
    } else {
        return findK(a, 0, b, 0, length / 2 + 1);
    }
  }
  private double findK(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int keyA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (keyA < keyB) {
            return findK(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findK(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}