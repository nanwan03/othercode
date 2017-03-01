public class Solution {
  public int[] interleave(int[] array) {
    if (array == null || array.length == 0) {
        	return array;
        }
        int left = 0;
        int right = array.length - 1;
        int cur = 0;
        
        int posNum = 0;
        int negNum = 0;
        while (cur <= right) {
        	if (array[cur] < 0) {
        		swap(array, cur++, left++);
        		posNum++;
        	} else {
        		swap(array, cur, right--);
        		negNum++; 
        	}
        }
        int posIndex = left;
        int negIndex = 0;
        while (posIndex < array.length && negIndex < posIndex) {
        	swap(array, posIndex++, negIndex);
        	negIndex += 2;
        }
        return array;
  }
  private void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}