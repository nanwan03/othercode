public class Solution {
  public int distance(String[] array, String s, String t) {
	    // Write your solution here.
	    int sIndex = -1;
	    int tIndex = -1;
	    int rst = Integer.MAX_VALUE;
	    for (int i = 0; i < array.length; ++i) {
	      if (array[i].equals(s)) {
	        sIndex = i;
	      } else if (array[i].equals(t)) {
	        tIndex = i;
	      }
	      if (sIndex != -1 && tIndex != -1) {
	    	  rst = Math.min(Math.abs(sIndex - tIndex), rst);
	      }
	    }
	    return rst == Integer.MAX_VALUE ? -1 : rst;
	  }
}
