public class Solution {
	private class Pair {
		int index;
		int val;
		Pair(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}
  public int[] largestAndSecond(int[] array) {
    if (array == null || array.length == 0) {
    	return array;
    }
    List<Pair> list = new ArrayList<Pair>();
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < array.length; i++) {
    	list.add(new Pair(i, array[i]));
    }
    while (list.size() > 1) {
    	List<Pair> nextRound = new ArrayList<Pair>();
    	for (int i = 0; i < list.size(); i = i + 2) {
    		if (i == list.size() - 1) {
    			nextRound.add(list.get(i));
    		} else {
    			Pair p1 = list.get(i);
    			Pair p2 = list.get(i + 1);
    			compare(p1, p2, map, nextRound);
    		}
    	}
    	list = nextRound;
    }
    
    return new int[]{list.get(0).val, findMax(map.get(list.get(0).index))};
  }
  
  private void compare(Pair p1, Pair p2, Map<Integer, List<Integer>> map, List<Pair> nextRound) {
	  if (p1.val <= p2.val) {
		  nextRound.add(p2);
		  if (!map.containsKey(p2.index)) {
			  map.put(p2.index, new ArrayList<Integer>());
		  }
		  map.get(p2.index).add(p1.val);
	  } else {
		  nextRound.add(p1);
		  if (!map.containsKey(p1.index)) {
			  map.put(p1.index, new ArrayList<Integer>());
		  }
		  map.get(p1.index).add(p2.val);
	  }
  }
  
  private int findMax(List<Integer> rst) {
	  int max = Integer.MIN_VALUE;
	  for (int i : rst) {
		  max = Math.max(max, i);
	  }
	  return max;
  }
}