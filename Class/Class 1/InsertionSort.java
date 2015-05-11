import java.util.Arrays;

public class InsertionSort {

	public void insertionSort(int[] array) {
		if (array == null) {
			return;
		}
		
		for (int index = 1; index < array.length; index++) {
			int pos = index;
			int value = array[pos];
			while (pos > 0 && array[pos - 1] > value) {
				array[pos] = array[pos - 1];
				pos--;
			}
			array[pos] = value;
		}
	}
	
	public static void main(String[] args) {
		InsertionSort solution = new InsertionSort();
		
		int[] array = null;
		solution.insertionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		solution.insertionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1, 2, 3, 4};
		solution.insertionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {4, 3, 2, 1};
		solution.insertionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {2, 5, 4, 1, 3};
		solution.insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
