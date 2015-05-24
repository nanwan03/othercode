public class Solution {
  public int[] sort(int[] A1, int[] A2) {
	    // Write your solution here.
	    if (A1 == null || A1.length == 0) {
	      return new int[0];
	    }
	    if (A1.length == A2.length) {
	      return A2;
	    }
	    int start = 0;
	    for (int i = 0; i < A2.length; i++) {
	      start = sortColor(A1, A2[i], start);
	    }
	    Arrays.sort(A1, start, A1.length);
	    return A1;
	  }
	  private int sortColor(int[] A1, int target, int start) {
	    int left = start;
	    int right = A1.length - 1;
	    int cur = start;
	    while (cur <= right) {
	      if (A1[cur] == target) {
	        cur++;
	      } else {
	        swap(A1, cur, right--);
	      }
	    }
	    return cur;
	  }
	  private void swap(int[] A1, int i, int j) {
	    int temp = A1[i];
	    A1[i] = A1[j];
	    A1[j] = temp;
	  }
}