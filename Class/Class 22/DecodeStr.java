import java.util.*;
/**
 * Given a string such as "a3b1c4d0" --> "aaabcccc".
 * Assumption:
 * 1). number of consecutive characters is in the range of [0, 9],
 * 2). valid characters in the string is 'a'-'z'.
 */
public class DecodeStr {

	// Assumption: the input is not null/empty, and it is valid String.
	public int decode(char[] input, int length) {
		return decodeLong(input, decodeShort(input, length));
	}
	
	public int decodeShort(char[] input, int length) {
		int end = 0;
		for (int i = 0; i < length; i += 2) {
			int count = getDigit(input[i + 1]);
			if (count <= 2) {
				for (int j = 0; j < count; j++) {
					input[end++] = input[i];
				}
			} else {
				input[end++] = input[i];
				input[end++] = input[i + 1];
			}
		}
		return end;
	}
	
	public int decodeLong(char[] input, int length) {
		int newLength = length;
		for (int i = 0; i < length; i++) {
			if (isDigit(input[i])) {
				newLength += getDigit(input[i]) - 2;
			}
		}
		int end = newLength - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (isDigit(input[i])) {
				int count = getDigit(input[i--]);
				for (int j = 0; j < count; j++) {
					input[end--] = input[i];
				}
			} else {
				input[end--] = input[i];
			}
		}
		return newLength;
	}
	
	public int getDigit(char digit) {
		return digit - '0';
	}
	
	public boolean isDigit(char digit) {
		return digit - '0' >= 0 && digit - '0' <= 9;
	}
	
	public static void main(String[] args) {
		DecodeStr solution = new DecodeStr();
		
		String str = "a0b3c1d4e2xxxxxxxxxxxxxxxxxxxx";
		char[] input = str.toCharArray();
		int length = 10;
		System.out.println(Arrays.copyOf(input, solution.decode(input, length)));
	}
}
