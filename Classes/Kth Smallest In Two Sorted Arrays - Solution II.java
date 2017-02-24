public class Solution {
  public int kth(int[] a, int[] b, int k) {
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
      while (cur < tmp.length && k > 1) {
        cur++;
        k--;
      }
      return tmp[cur];
    } else {
    	return Math.min(a[curA], b[curB]);
    }
  }
}
