public class Solution {
  public String shortest(String input, int k) {
    // Write your solution here.
	if (input == null || input.length() < k) {
		return "";
	}
	int left = 0;
	int leftRst = -1;
	int rightRst = input.length();
	int[] map = new int[256];
	int types = 0;
	for (int i = 0; i < input.length(); ++i) {
		if (map[input.charAt(i)]++ == 0) {
			types++;
		}
		if (types == k) {
			while (map[input.charAt(left)]-- > 1) {
				left++;
			}
			if (i - left < rightRst - leftRst) {
				leftRst = left;
				rightRst = i;
			}
			left++;
			types--;
		}
	}
	
    return leftRst == -1 ?  "" : input.substring(leftRst, rightRst + 1);
  }
}
