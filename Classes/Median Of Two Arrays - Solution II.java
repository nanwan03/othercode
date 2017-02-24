public class Solution {
  public double median(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int length = a.length + b.length;
    int middle = kth(a, b, length / 2 + 1);
    if ((length & 0x01) == 0) {
      int middleNext = kth(a, b, length / 2);
      return (double)(middle + middleNext) / 2.0;
    } else {
      return (double)(middle);
    }
  }
  private int kth(int[] a, int[] b, int k) {
    // Write your solution here.
	if (k > a.length + b.length) {
		return -1;
	}
    int curA = 0;
    int curB = 0;
    while (k > 1 && curA < a.length && curB < b.length) {
      if (a[curA] < b[curB]) {
        curA++;
      } else {
        curB++;
      }
      k--;
    }
    if (curA == a.length || curB == b.length) {
    	int[] tmp = curB == b.length ? a : b;
      int cur = curB == b.length ? curA : curB;
      while (k > 1) {
        cur++;
        k--;
      }
      return tmp[cur];
    } else {
    	return Math.min(a[curA], b[curB]);
    }
  }
}