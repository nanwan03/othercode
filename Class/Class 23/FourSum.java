import java.util.*;

/**
 * Determine if there exists four numbers in an integer array,
 * the sum of the four numbers is a given target value.
 */
public class FourSum {

	public boolean fourSum(int[] array, int target) {
		assert array != null && array.length >= 4;
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++) {
			for (int j = i + 1; j < array.length - 2; j++) {
				int left = j + 1;
				int right = array.length - 1;
				int curTarget = target - array[i] - array[j];
				while (left < right) {
					int sum = array[left] + array[right];
					if (sum == curTarget) {
						return true;
					} else if (sum < curTarget) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return false;
	}
	
	static class Element implements Comparable<Element> {
		int left;
		int right;
		int sum;
		
		Element(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}
		
		@Override
		public int compareTo(Element another) {
			if (this.sum != another.sum) {
				return this.sum - another.sum;
			} else if (this.right != another.right) {
				return this.right - another.right;
			} else {
				return this.left - another.left;
			}
		}
	}

	public boolean fourSumI(int[] array, int target) {
		assert array != null && array.length >= 4;
		Element[] pairSum = getPairSum(array);
		Arrays.sort(pairSum);
		int left = 0;
		int right = pairSum.length - 1;
		while (left < right) {
			if (pairSum[left].sum + pairSum[right].sum == target
					&& pairSum[left].right < pairSum[right].left) {
				return true;
			} else if (pairSum[left].sum + pairSum[right].sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return false;
	}
	
	private Element[] getPairSum(int[] array) {
		Element[] pairSum = new Element[array.length * (array.length - 1) / 2];
		int curIndex = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				pairSum[curIndex++] = new Element(j, i, array[i] + array[j]);
			}
		}
		return pairSum;
	}
	
	static class Pair {
		int left;
		int right;
		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	public boolean fourSumII(int[] array, int target) {
		assert array != null && array.length >= 4;
		HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				int pairSum = array[j] + array[i];
				if (map.containsKey(target - pairSum)
						&& map.get(target - pairSum).get(0).right < j) {
					return true;
				}
				if (!map.containsKey(pairSum)) {
					map.put(pairSum, new ArrayList<Pair>());
				}
				map.get(pairSum).add(new Pair(j, i));
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		FourSum solution = new FourSum();
		
		int[] array = {1, 2, 3, 4};
		int target = 10;
		System.out.println(solution.fourSum(array, target));
		System.out.println(solution.fourSumI(array, target));
		System.out.println(solution.fourSumII(array, target));
		
		target = 12;
		System.out.println(solution.fourSum(array, target));
		System.out.println(solution.fourSumI(array, target));
		System.out.println(solution.fourSumII(array, target));
		
		target = 12;
		array = new int[] {3, 1, 3, 3, 8, 3};
		System.out.println(solution.fourSum(array, target));
		array = new int[] {3, 1, 3, 3, 8, 3};
		System.out.println(solution.fourSumI(array, target));
		array = new int[] {3, 1, 3, 3, 8, 3};
		System.out.println(solution.fourSumII(array, target));
	}
}
