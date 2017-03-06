public class Solution {
  public int[] heapsort(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
    	return array;
    }
    int size = array.length;
    for (int i = size / 2; i >= 0; i--) {
    	adjust(array, i, size);
    }
    for (int i = size - 1; i > 0; i--) {
        swap(array, 0, i);
        size--;
        adjust(array, 0, size);
    }
    return array;
  }
  private void adjust(int[] A, int i, int size) {
		int min = i;
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		if (left < size && A[left] > A[min]) {  //sort from biggest to smallest
			min = left;
		}
		if (right < size && A[right] > A[min]) {
			min = right;
		}
		if (i == min) {
			return;
		}
		swap(A, min, i);
		adjust(A, min, size);
    }
    private void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
