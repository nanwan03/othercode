import java.util.Arrays;
/**
 * Array reorder in place implementation.
 * 
 * Suppose I have an array of chars, the requirement is as follow:
 * 1). [C_1, C_2, ..., C_2k]
 * --> [C_1, C_k+1, C2, C_k+2, ..., C_k, C_2k]
 * 
 * 2). [C_1, C_2, ..., C_2k+1]
 * --> [C_1, C_K+1, C2, C_K+2, ... C_K, C_2k, C_2k+1]
 * 
 */
public class ArrayReOrder {

	public void reorder(int[] array) {
		if (array == null) {
			return;
		}
		int length = array.length;
		if (length % 2 != 0) {
			reorder(array, 0, length - 2);
		} else {
			reorder(array, 0, length - 1);
		}
	}

	private void reorder(int[] array, int left, int right) {
		int length = right - left + 1;
		assert length % 2 == 0;
		if (length <= 2) {
			return;
		}
		int leftLength = 2 * (length / 4);
		int leftEnd = left + leftLength - 1;
		int leftMid = left + leftLength / 2;
		rightShift(array, leftMid, leftMid + length / 2 - 1, leftLength / 2);
		reorder(array, left, leftEnd);
		reorder(array, leftEnd + 1, right);
	}

	public void rightShift(int[] array, int left, int right, int shift) {
		reverse(array, right - shift + 1, right);
		reverse(array, left, right - shift);
		reverse(array, left, right);
	}

	public void reverse(int[] array, int left, int right) {
		while (left < right) {
			swap(array, left++, right--);
		}
	}

	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		ArrayReOrder solution = new ArrayReOrder();

			/*
		char[] array = null;
		solution.reorder(array);
		System.out.println(Arrays.toString(array));

		array = new char[0];
		solution.reorder(array);
		System.out.println(Arrays.toString(array));

		array = new char[] { 'A', 'B', '1', '2' };
		solution.reorder(array);
		System.out.println(Arrays.toString(array));

		array = new char[] { 'A', 'B', '1', '2', '3' };
		solution.reorder(array);
		System.out.println(Arrays.toString(array));
	*/
		//array = new char[] { 'A', 'B', 'C', 'D', 'E', '1', '2', '3', '4', '5' };
		int[] array = null;
		array = new int[] {11, 27, 10, 7, 35, 28, 18, -13, -8, -12, -15, -14, -1, -7, -12};
		solution.reorder(array);
		System.out.println(Arrays.toString(array));
	}
}
