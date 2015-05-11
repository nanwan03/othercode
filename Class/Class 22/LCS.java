/**
 * 1). longest common substring of two strings.
 * Example:
 * "student" & "sweden", then return ¡°den¡±. 
 * 2). length of longest common subsequence of two strings.
 * Example:
 * "student" & "swedenacy", then return 4.
 */
public class LCS {

	public String LCSubstring(String s1, String s2) {
		assert s1 != null && s2 != null;
		int s1End = 0;
		int longest = 0;
		int[][] length = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1;
					if (length[i][j] > longest) {
						s1End = i;
						longest = length[i][j];
					}
				}
			}
		}
		return s1.substring(s1End - longest, s1End);
	}
	
	public int LCSubsequence(String s1, String s2) {
		assert s1 != null && s2 != null;
		int longest = 0;
		int[][] length = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1;
					longest = Math.max(longest, length[i][j]);
				} else {
					length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);
				}
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		LCS solution = new LCS();
		
		String s1 = "";
		String s2 = "abc";
		System.out.println(solution.LCSubstring(s1, s2));
		System.out.println(solution.LCSubsequence(s1, s2));
		
		s1 = "student";
		s2 = "swendenacy";
		System.out.println(solution.LCSubstring(s1, s2));
		System.out.println(solution.LCSubsequence(s1, s2));
	}
}
