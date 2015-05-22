public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // write your solution here
     List<List<Integer>> rst = new ArrayList<List<Integer>>();
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < array.length; i++) {
    	if (!map.containsKey(array[i])){
    		map.put(array[i], new ArrayList<Integer>());
    	}
    	map.get(array[i]).add(i);
    }
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
    	  List<Integer> indexList = map.get(target - array[i]);
    	  for (int index : indexList) {
    		  if (index > i) {
    			  List<Integer> items = new ArrayList<Integer>();
    			  items.add(i);
    			  items.add(index);
    			  rst.add(items);
    		  }
    	  }
      }
    }
    return rst;
  }
}