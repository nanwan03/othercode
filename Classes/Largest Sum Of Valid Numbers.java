public class Solution {
	private static final int N = 8;
  public int largestSum(int[][] matrix) {
    Integer[] configs = getValidConfig();
    int[][] dp = new int[N][configs.length];
    int rst = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
    	for (int j = 0; j < configs.length; j++) {
    		if (i > 0) {
    			for (int k = 0; k < configs.length; k++) {
    				if (notconflict(configs[j], configs[k])) {
    					dp[i][j] = Math.max(dp[i][j], dp[i - 1][k]);
    				}
    			}
    		}
    		dp[i][j] += getSum(matrix[i], configs[j]);
    		rst = Math.max(rst, dp[i][j]);
    	}
    }
    return rst;
  }
  private Integer[] getValidConfig() {
	  List<Integer> rst = new ArrayList<Integer>();
	  int temp = 0;
	  helper(rst, temp, 0);
	  return rst.toArray(new Integer[0]);
  }
  private void helper(List<Integer> rst, int temp, int index) {
	  rst.add(temp);
	  for (int i = index; i < N; i++) {
		  helper(rst, (temp | 1 << i), i + 2);
	  }
  }
  private boolean notconflict(int c1, int c2) {
	  return ((c1 & c2) == 0) && (((c1 >> 1) & c2) == 0) && (((c1 << 1) & c2) == 0);
  }
  private int getSum(int[] matrix, int c1) {
	  int rst = 0;
	  for (int i = 0; i < N; i++) {
		  if (((c1 >> i) & 1) == 1) {
			  rst += matrix[i];
		  }
	  }
	  return rst;
  }
}