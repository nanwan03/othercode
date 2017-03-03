public class Solution {
  public int minReplacements(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return 0;
    }
  	int[] cache = new int[input.length()];
  	int count = 0;
  	for (int i = 0; i < input.length(); ++i) {
  		if (input.charAt(i) == 'b'){
  			count++;
  		}
  		cache[i] = count;
	  }
    return helper(input, cache, input.length() - 1, 'b');
  }
  private int helper(String input, int[] cache, int index, char tail) {
	  if (index == 0) {
	    return 0;
	  }
	  if (input.charAt(index) == 'a') {
		  return Math.min(1 + helper(input, cache, index - 1, 'b'), cache[index - 1]);
	  } else {
		  return Math.min(1 + cache[index - 1], helper(input, cache, index - 1, 'b'));
	  }
  }
}
