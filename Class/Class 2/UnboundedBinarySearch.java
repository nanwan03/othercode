/**
 * Binary search implementation on an dictionary with unknown size. Assumption:
 * 1. The dictionary is an unknown sized array, it only provides get(int index) functionality,
 * if the index asked for is out of right bound, it will return  null.
 * 2. The elements in the dictionary are all Integers.
 * 
 */
public class UnboundedBinarySearch {
	/*
	 * Wrapper class for an unknown sized int array. The length() method is not
	 * provided to outside the class.
	 */
	public static class Dictionary {
		private int[] array;

		public Dictionary(int[] array) {
			this.array = array;
		}

		public Integer get(int index) {
			if (array == null || index >= array.length) {
				return null;
			}
			return array[index];
		}
	}

	public int unboundedBinarySearch(Dictionary dictionary, int target) {
		if (dictionary == null) {
			return -1;
		}
		int left = 0;
		// initialize right index as 2 ^ 0 - 1
		int right = 0;
		while (dictionary.get(right) != null && dictionary.get(right).intValue() < target) {
			// 1. move left to right,
			// 2. double right index, since the array's indices are started from 0,
			// we use right = 2 ^ n - 1
			left = right;
			right = 2 * right + 1;
		}
		// not very necessary, but can return earlier.
		if (dictionary.get(right) != null && dictionary.get(right).intValue() == target) {
			return right;
		}
		return binarySearch(dictionary, target, left, right);
	}

	public int binarySearch(Dictionary dict, int target, int left, int right) {
		// classical binary search
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (dict.get(mid) == null || dict.get(mid).intValue() > target) {
				right = mid - 1;
			} else if (dict.get(mid).intValue() < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		UnboundedBinarySearch solution = new UnboundedBinarySearch();

		int target = 5;
		Dictionary dictionary = null;
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(null);
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(new int[0]);
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(new int[] { 1, 2 });
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(new int[] { 6 });
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		target = 9999;
		dictionary = new Dictionary(generateSequence(10001));
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(generateSequence(9998));
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		target = 7;
		dictionary = new Dictionary(generateSequence(7));
		System.out.println(solution.unboundedBinarySearch(dictionary, target));

		dictionary = new Dictionary(generateSequence(10001));
		System.out.println(solution.unboundedBinarySearch(dictionary, target));
	}

	/*
	 * Generate int array of sequence from 0 to a specified number.
	 */
	public static int[] generateSequence(int number) {
		assert number >= 0;
		int[] result = new int[number + 1];
		for (int index = 0; index <= number; index++) {
			result[index] = index;
		}
		return result;
	}
}
