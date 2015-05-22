public class Solution {
	private class StringComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return b.length() - a.length();
		}
	}
  public int largestProduct(String[] dict) {
    if (dict == null || dict.length == 0) {
    	return 0;
    }
    Arrays.sort(dict, new StringComparator());
    Map<String, Integer> map = getMap(dict);
    int max = 0;
    for (int i = 0; i< dict.length; i++) {
    	for (int j = 0; j < i; j++) {
    		if ((map.get(dict[i]) & map.get(dict[j])) == 0) {
    			max = Math.max(max, dict[i].length() * dict[j].length());
    		}
    	}
    }
    return max;
  }
  private Map<String, Integer> getMap(String[] dict) {
	  Map<String, Integer> map = new HashMap<String, Integer>();
	  for (String str : dict) {
		  int rst = 0;
		  for (char c : str.toCharArray()) {
			  rst |= 1 << (c - 'a');
		  }
		  map.put(str, rst);
	  }
	  return map;
  }
}