import java.util.*;
/**
 * Common elements problems.
 * 1). common elements in two sorted array.
 * 2). common elements in three sorted array.
 */
public class CommonElements {
	
	public List<Integer> common(int[] array1, int[] array2) {
		assert array1 != null && array2 != null;
		int i1 = 0;
		int i2 = 0;
		List<Integer> common = new ArrayList<Integer>();
		while (i1 < array1.length && i2 < array2.length) {
			if (array1[i1] == array2[i2]) {
				common.add(array1[i1]);
				i1++;
				i2++;
			} else if (array1[i1] < array2[i2]) {
				i1++;
			} else {
				i2++;
			}
		}
		return common;
	}
	
	public List<Integer> common(int[] array1, int[] array2, int[] array3) {
		assert array1 != null && array2 != null && array3 != null;
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		List<Integer> common = new ArrayList<Integer>();
		while (i1 < array1.length && i2 < array2.length && i3 < array3.length) {
			if (array1[i1] == array2[i2] && array1[i1] == array3[i3]) {
				common.add(array1[i1]);
				i1++;
				i2++;
				i3++;
			} else if (array1[i1] <= array2[i2] && array1[i1] <= array3[i3]) {
				i1++;
			} else if (array2[i2] <= array1[i1] && array2[i2] <= array3[i3]) {
				i2++;
			} else {
				i3++;
			}
		}
		return common;
	}
}
