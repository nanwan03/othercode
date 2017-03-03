public class Solution {
  public String largestNumber(String[] input) {
    // Write your solution here.
	if (input == null || input.length == 0) {
		return null;
	}
	if (input.length == 1) {
		return input[0];
	}
	String str = null;
	return helper(str, input, 0);
  }
  private String helper(String str, String[] input, int pos) {
	  if (pos == input.length) {
		  str = compare(str, input);
		  return str;
	  }
	  for (int i = pos; i < input.length; ++i) {
		  swap(input, i, pos);
		  str = helper(str, input, pos + 1);
		  swap(input, i, pos);
	  }
	  return str;
  }
  private void swap(String[] input, int i, int j) {
	  String str = input[i];
	  input[i] = input[j];
	  input[j] = str;
  }
  private String compare(String str, String[] input) {
	  StringBuilder sb = new StringBuilder();
	  for (String s : input) {
		  sb.append(s);
	  }
	  String target = sb.toString();
	  if (str == null) {
		  return target;
	  } else {
		  for (int i = 0; i < target.length(); ++i) {
			  if (str.charAt(i) < target.charAt(i)) {
				  return target;
			  } else if (str.charAt(i) > target.charAt(i)) {
				  return str;
			  }
		  }
	  }
	  return str;
	  
  }
}
