import java.util.*;
/**
 * Replace all substrings s1 in a string s with s2
 * (with possible minimum memory allocation, in-place if possible).
 */
public class StrReplace {

	public int replace(char[] str, int length, String s1, String s2) {
		assert s1 != null && s2 != null;
		assert !s1.isEmpty();
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		if (a1.length >= a2.length) {
			return replaceShorter(str, length, a1, a2);
		} else {
			return replaceLonger(str, length, a1, a2);
		}
	}
	
	public int replaceShorter(char[] str, int length, char[] a1, char[] a2) {
		int end = 0;
		for (int i = 0; i <= length - a1.length; ) {
			if (equalSubArray(str, i, a1)) {
				copyFromLeft(str, end, a2);
				i += a1.length;
				end += a2.length;
			} else {
				str[end++] = str[i++];
			}
		}
		return end;
	}
	
	public int replaceLonger(char[] str, int length, char[] a1, char[] a2) {
		ArrayList<Integer> matches = new ArrayList<Integer>();
		for (int i = 0; i <= length - a1.length; i++) {
			if (equalSubArray(str, i, a1)) {
				matches.add(i + a1.length - 1);
			}
		}
		int newLength = length + matches.size() * (a2.length - a1.length);
		int lastIndex = matches.size() - 1;
		int end = newLength - 1;
		for (int i = length - 1; i >= 0; ) {
			if (lastIndex >= 0 && i == matches.get(lastIndex)) {
				copyFromRight(str, end, a2);
				lastIndex--;
				i -= a1.length;
				end -= a2.length;
			} else {
				str[end--] = str[i--];
			}
		}
		return newLength;
	}
	
	public boolean equalSubArray(char[] array, int index, char[] a1) {
		for (int i = 0; i < a1.length; i++) {
			if (array[index + i] != a1[i]) {
				return false;
			}
		}
		return true;
	}
	
	public void copyFromLeft(char[] array, int index, char[] a2) {
		for (int i = 0; i < a2.length; i++) {
			array[index++] = a2[i];
		}
	}
	
	public void copyFromRight(char[] array, int index, char[] a2) {
		for (int i = a2.length - 1; i >= 0; i--) {
			array[index--] = a2[i];
		}
	}
	
	public static void main(String[] args) {
		StrReplace solution = new StrReplace();
		
		String str = "abcaabcabcabcxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		int length = 13;
		String s1 = "abc";
		String s2 = "xy";
		char[] input = str.toCharArray();
		
		System.out.println(Arrays.copyOf(input, solution.replace(input, length, s1, s2)));
		
		input = str.toCharArray();
		s2 = "xyz";
		System.out.println(Arrays.copyOf(input, solution.replace(input, length, s1, s2)));

		input = str.toCharArray();
		s2 = "opqr";
		System.out.println(Arrays.copyOf(input, solution.replace(input, length, s1, s2)));
	}
}
