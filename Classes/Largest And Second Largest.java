public class Solution {
	private class Pair {
		int first;
		int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
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
    
    return new int[]{list.get(0).second, findMax(map.get(list.get(0).first))};
  }
  
  private void compare(Pair p1, Pair p2, Map<Integer, List<Integer>> map, List<Pair> nextRound) {
	  if (p1.second <= p2.second) {
		  nextRound.add(p2);
		  if (!map.containsKey(p2.first)) {
			  map.put(p2.first, new ArrayList<Integer>());
		  }
		  map.get(p2.first).add(p1.second);
	  } else {
		  nextRound.add(p1);
		  if (!map.containsKey(p1.first)) {
			  map.put(p1.first, new ArrayList<Integer>());
		  }
		  map.get(p1.first).add(p2.second);
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