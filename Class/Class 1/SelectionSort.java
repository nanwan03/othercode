import java.util.Arrays;

public class SelectionSort {

	public void selectionSort(int[] array) {
		// sanity check before the main logic is applied.
		// conditions to consider: null? empty? ......
		if (array == null) {
			return;
		}
		
		// we do not need to iterate the last element of the array!
		for (int index = 0; index < array.length - 1; index++) {
			int minIndex = index;
			for (int tmpIndex = index + 1; tmpIndex < array.length; tmpIndex++) {
				if (array[tmpIndex] < array[minIndex]) {
					minIndex = tmpIndex;
				}
			}
			swap(array, index, minIndex);
		}
	}
	
	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		SelectionSort solution = new SelectionSort();
		
		int[] array = null;
		solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1, 2, 3, 4};
		solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {4, 3, 2, 1};
		solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {2, 4, 1, 5, 3};
		solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
