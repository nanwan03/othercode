import java.util.Arrays;

public class QuickSort {

	public void quickSort(int[] array) {
		if (array == null) {
			return;
		}
		quickSort(array, 0, array.length - 1);
	}
	
	public void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotPos = partition(array, left, right);
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}
	
	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	private int partition(int[] array, int left, int right) {
		int pivotPos = pivotPos(left, right);
		int pivot = array[pivotPos];
		swap(array, pivotPos, right);

		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else {
				swap(array, leftBound, rightBound--);
			}
		}
		/* yet another partition implementation.
		for (int index = left; index <= right - 1; index++) { 
			if (array[index] < pivot) {
				swap(array, leftBound++, index);
			}
		}
		*/
		swap(array, leftBound, right);
		return leftBound;		
	}
	
	private int pivotPos(int left, int right) {
		return left + (int) (Math.random() * (right - left + 1));
	}
	
	public static void main(String[] args) {
		QuickSort solution = new QuickSort();
		
		int[] array = null;
		solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1, 2, 3, 4};
		solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {4, 3, 2, 1};
		solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {2, 5, 3, 1, 4};
		solution.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
