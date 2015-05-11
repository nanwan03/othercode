import java.util.Arrays;

public class MergeSort {

	public void mergeSort(int[] array) {
		// sanity check at first
		if (array == null) {
			return;
		}
		// allocate helper array to help merge step
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}
	
	public void copyArray(int[] source, int[] dest, int left, int right) {
		for (int index = left; index <= right; index++) {
			dest[index] = source[index];
		}
	}
	
	private void mergeSort(int[] array, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int mid = left + (right - left) / 2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}
	
	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		// first copy the content to helper array
		copyArray(array, helper, left, right);
		
		int leftIndex = left;
		int rightIndex = mid + 1;
		
		while(leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] <= helper[rightIndex]) {
				array[left++] = helper[leftIndex++];
			} else {
				array[left++] = helper[rightIndex++];
			}
		}
		
		while(leftIndex <= mid) {
			array[left++] = helper[leftIndex++];
		}
		/* yet another implementation of the merge step.
		for (int index = left; index <= right; index++) {
			if (rightIndex > right || leftIndex <= mid && helper[leftIndex] <= helper[rightIndex]) {
				array[index] = helper[leftIndex++];
			} else {
				array[index] = helper[rightIndex++];
			}
		}
		*/
	}
	
	public static void main(String[] args) {
		MergeSort solution = new MergeSort();
		
		int[] array = null;
		solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1, 2, 3, 4};
		solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {4, 3, 2, 1};
		solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {2, 4, 1, 5, 3};
		solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}
