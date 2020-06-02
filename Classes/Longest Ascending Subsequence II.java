public class Solution {
  public int[] longest(int[] a) {
    // Write your solution here
    int[][] dp = new int[a.length][2];
	    int globalMax = 0;
	    int start = 0;
	    for (int i = 0; i < a.length; ++i) {
	    	dp[i] = new int[] {1, i};
	    	for (int j = 0; j < i; ++j) {
	    		if (a[j] < a[i]) {
	    			if (dp[i][0] < dp[j][0] + 1) {
	    				dp[i] = new int[] {dp[j][0] + 1, j}; 
	    			}
	    		}
	    	}
	    	if (globalMax < dp[i][0]) {
	    		globalMax = dp[i][0];
	    		start = i;
	    	}
	    }
	    int[] rst = new int[globalMax];
	    for (int i = globalMax - 1; i >= 0; --i) {
	    	rst[i] = a[start];
	    	start = dp[start][1];
	    }
	    return rst;
  }
}
