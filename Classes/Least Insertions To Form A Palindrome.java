public class Solution {
  public int leastInsertion(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return 0;
    }
    int[][] dp = new int[input.length()][input.length()];
    for (int end = 1; end < input.length(); end++) {
    	for (int start = end - 1; start >= 0; start--) {
      		if (input.charAt(start) == input.charAt(end)) {
      			dp[start][end] = dp[start + 1][end - 1];
      		} else {
      	    dp[start][end] = Math.min(dp[start][end - 1], dp[start + 1][end]) + 1;	    
      		}
    	}
    }
    return dp[0][input.length() - 1];
  }
}