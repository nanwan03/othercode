public class Solution {
  public boolean formRing(String[] input) {
    // Write your solution here.
	if (input == null || input.length == 0) {
		return false;
	}
    List<String> items = new ArrayList<String>();
    boolean[] isused = new boolean[input.length];
    return helper(items, input, isused, input.length);
    
  }
  private boolean helper(List<String> items, String[] input, boolean[] isused, int left) {
	  if (left == 0) {
		  return items.get(0).charAt(0) == items.get(items.size() - 1).charAt(items.get(items.size() - 1).length() - 1);
	  }
	  for (int i = 0; i < input.length; ++i) {
		  if (!isused[i]
				  && (items.size() == 0 
				  		|| items.get(items.size() - 1).charAt(items.get(items.size() - 1).length() - 1) == input[i].charAt(0))) {
			  items.add(input[i]);
			  isused[i] = true;
			  boolean flag = helper(items, input, isused, left - 1);
			  if (flag) {
				  return true;
			  }
			  isused[i] = false;
			  items.remove(items.size() - 1);
				  
		  }
	  }
	  return false;
  }
}
