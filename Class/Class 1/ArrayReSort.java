import java.util.Arrays;
/**
 * Resort an array with a different way.
 * 
 * Assumption:
 * The input array will be always as form
 * ['A', '1', 'B', '2', 'C', '3', ...]
 * The characters are sorted upper case letters in ['A', 'I'].
 * Each upper case letter character is followed by a character in ['1', '9'].
 * The mapping is 'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'I' -> '9'.
 * 
 * Requirement:
 * Resort the array to group all the upper case letters to
 * the left partition of the array, and group all the characters representing
 * int values to the right partition of the array, both partitions are sorted.
 * 
 * Example:
 * ['A', '1', 'B', '2'] -> ['A', 'B', '1', '2']
 * ['A', '1', 'B', '2', 'C', '3'] -> ['A', 'B', 'C', '1', '2', '3']
 * 
 */
public class ArrayReSort {

	public void reSort(char[] array) {
		if (array == null) {
			return;
		}
		assert array.length % 2 == 0;
		char[] helper = new char[array.length];
		reSort(array, helper, 0, array.length - 1);
	}

	public void reSort(char[] array, char[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2 ;
		reSort(array, helper, left, mid);
		reSort(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}

	private void merge(char[] array, char[] helper, int left, int mid, int right) {
		copyArray(array, helper, left, right);
		int leftIndex = left;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (isLessThan(helper[leftIndex], helper[rightIndex])) {
				array[left++] = helper[leftIndex++];
			} else {
				array[left++] = helper[rightIndex++];
			}
		}
		while (leftIndex <= mid) {
			array[left++] = helper[leftIndex++];
		}
	}

	/*
	 * Letters will always be less than integers.
	 */
	private boolean isLessThan(char charOne, char charTwo) {
		if (isLetter(charOne) && !isLetter(charTwo)) {
			return true;
		} else if (!isLetter(charOne) && isLetter(charTwo)) {
			return false;
		} else {
			return charOne - charTwo <= 0;
		}
	}

	/*
	 * The only valid letters are 'A' to 'I'.
	 */
	private boolean isLetter(char character) {
		return (character - 'A') >= 0 && (character - 'A') < 9;
	}

	public void copyArray(char[] source, char[] dest, int left, int right) {
		for (int index = left; index <= right; index++) {
			dest[index] = source[index];
		}
	}

	public static void main(String[] args) {
		ArrayReSort solution = new ArrayReSort();

		char[] array = null;
		solution.reSort(array);
		System.out.println(Arrays.toString(array));

		array = new char[0];
		solution.reSort(array);
		System.out.println(Arrays.toString(array));

		array = new char[] { 'A', '1', 'B', '2', 'C', '3', 'D', '4' };
		solution.reSort(array);
		System.out.println(Arrays.toString(array));

		array = new char[] { 'A', '1', 'B', '2', 'C', '3' };
		solution.reSort(array);
		System.out.println(Arrays.toString(array));

		array = new char[] { 'A', '1', 'B', '2', 'C', '3', 'D', '4', 'E', '5' };
		solution.reSort(array);
		System.out.println(Arrays.toString(array));
	}
}
