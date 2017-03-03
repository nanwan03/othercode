public class Solution {
  public String smallest(String s1, String s2) {
    	if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
    		return "";
    	}
    	int[] total = new int[256];
    	int[] found = new int[256];
    	for (int i = 0; i < s2.length(); i++) {
    		total[s2.charAt(i)]++;
    	}
    	int start = -1;
    	int end = s1.length();
    	int left = 0;
    	int windowSize = 0;
    	for (int i = 0; i < s1.length(); i++) {
    		if (total[s1.charAt(i)] != 0) {
    			found[s1.charAt(i)]++;
    			if (found[s1.charAt(i)] <= total[s1.charAt(i)]) {
    				windowSize++;
    			}
    			if (windowSize == s2.length()) {
    				while (total[s1.charAt(left)] == 0 ||
    						--found[s1.charAt(left)] >= total[s1.charAt(left)]) {
    					left++;
    				}
    				if (i - left < end - start) {
    					start = left;
    					end = i;
    				}
    				left++;
    				windowSize--;
    			}
    		}
    	}
    	return start == -1 ? "" : s1.substring(start, end + 1);
  }
}
