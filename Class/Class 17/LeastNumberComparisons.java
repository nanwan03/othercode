import java.util.*;
/**
 * Least number of comparisons for getting
 * 1). the largest and smallest number.
 * 2). the largest and the second largest number.
 */
public class LeastNumberComparisons {
	// the Pair class is a wrapper of two integers.
	static class Pair {
		int first;
		int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public Pair largestAndSmallest(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		ArrayList<Integer> larger = new ArrayList<Integer>();
		ArrayList<Integer> smaller = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i += 2) {
			if (i == array.length - 1) {
				// if we have odd number of elements in the array,
				// we need to add the last element to both larger
				// smaller groups.
				smaller.add(array[i]);
				larger.add(array[i]);
			} else if (array[i] <= array[i + 1]) {
				smaller.add(array[i]);
				larger.add(array[i + 1]);
			} else {
				smaller.add(array[i + 1]);
				larger.add(array[i]);
			}
		}
		// use Pair to store the largest number and smallest number,
		return new Pair(findLargest(larger), findSmallest(smaller));
	}
	
	public Pair largestAndSecond(int[] array) {
		if (array == null || array.length < 2) {
			return null;
		}
		// key: the index in original array.
		// value: the list of values smaller than array[key]
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		// binary reduction, use the list of all <index, array[index]> pairs conducted
		// by the original array as the initial list. 
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < array.length; i++) {
			list.add(new Pair(i, array[i]));
		}
		
		while (list.size() > 1) {
			ArrayList<Pair> nextRound = new ArrayList<Pair>();
			for (int i = 0; i < list.size(); i += 2) {
				if (i + 1 < list.size()) {
					Pair p1 = list.get(i);
					Pair p2 = list.get(i + 1);
					compare(p1, p2, nextRound, map);
				} else {
					nextRound.add(list.get(i));
				}
			}
			list = nextRound;
		}
		Pair largest = list.get(0);
		return new Pair(largest.second, findLargest(map.get(largest.first)));
	}

	private void compare(Pair p1, Pair p2, ArrayList<Pair> nextRound, HashMap<Integer,
			ArrayList<Integer>> map) {
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
	
	private int findLargest(ArrayList<Integer> list) {
		int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			max = Math.max(max, list.get(i));
		}
		return max;
	}
	
	private int findSmallest(ArrayList<Integer> list) {
		int min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(min, list.get(i));
		}
		return min;
	}
	
	public static void main(String[] args) {
		LeastNumberComparisons solution = new LeastNumberComparisons();
		
		int[] array = new int[] {1, 2, 3};
		Pair largestAndSmallest = solution.largestAndSmallest(array);
		Pair largestAndSecond = solution.largestAndSecond(array);
		System.out.println("largest: " + largestAndSmallest.first + ", smallest: " + largestAndSmallest.second);
		System.out.println("largest: " + largestAndSecond.first + ", second largest: " + largestAndSecond.second);

		array = new int[] {5, 1, 2, 4, 3};
		largestAndSmallest = solution.largestAndSmallest(array);
		largestAndSecond = solution.largestAndSecond(array);
		System.out.println("largest: " + largestAndSmallest.first + ", smallest: " + largestAndSmallest.second);
		System.out.println("largest: " + largestAndSecond.first + ", second largest: " + largestAndSecond.second);
		
		array = new int[] {1, 1, 2, 2, 3, 4, 5, 6};
		largestAndSmallest = solution.largestAndSmallest(array);
		largestAndSecond = solution.largestAndSecond(array);
		System.out.println("largest: " + largestAndSmallest.first + ", smallest: " + largestAndSmallest.second);
		System.out.println("largest: " + largestAndSecond.first + ", second largest: " + largestAndSecond.second);
	}
}
