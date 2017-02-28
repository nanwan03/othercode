public class Solution {
  public int minReplacements(String input) {
    // Write your solution here.
    int num = stringToNum(input);
    int length = input.length();
    int target = 0;
    int rst = getDistance(target ^ num);
    for (int i = length - 1; i >= 0; --i) {
    	target |= 1 << i;
    	rst = Math.min(rst, getDistance(target ^ num));
    }
    return rst;
  }
  private int stringToNum(String input) {
	  char[] chars = input.toCharArray();
	  int rst = 0;
	  for (char c : chars) {
		  int tmp = c == 'a' ? 1 : 0;
		  rst = rst * 2 + tmp;
	  }
	  return rst;
  }
  private int getDistance(int num) {
	  int count = 0;
	  while (num != 0) {
		  if ((num & 1) == 1) {
			  count++;
		  }
		  num >>= 1;
	  }
	  return count;
  }
}
