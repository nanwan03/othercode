public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if(array == null || array.length == 0 || k == 0) {
          return new int[k];
        }
        int index = binarySearch(array, target);
        int[] rst = new int[k];
        int flag = 0;
        if (index == 0) {
        	for (flag = 0; flag < k; ++flag) {
        		rst [flag] = array[flag];
        	}
        	return rst;
        }
        int left = index - 1;
        int right = index;

        while (left >= 0 && right < array.length) {
        	if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
        		rst[flag++] = array[left--];
        	} else {
        		rst[flag++] = array[right++];
        	}
        	if (flag == k) {
        		return rst;
        	}
        }
        
        while (flag < k && left >= 0) {
        	rst[flag++] = array[left--];
        }
        while (flag < k && right < array.length) {
        	rst[flag++] = array[right++];
        }
        return rst;
  }
  private int binarySearch(int[] A, int target) {
    	int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
        	int mid = left + (right - left) / 2;
        	if (A[mid] == target) {
        		return mid;
        	} else if (A[mid] < target) {
        		left = mid + 1;
        	} else {
        		right = mid;
        	}
        }
        if (A[left] == target) {
        	return left;
        } else if (A[right] == target) {
        	return right;
        } else {
        	return A[left] > target ? left : right;
        }
    }
}
