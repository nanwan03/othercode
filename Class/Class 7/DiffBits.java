/**
 * Determine the number of bits that are different
 * between two positive integers.
 * 
 */
public class DiffBits {
	
	public int diffBits(int num1, int num2) {
		assert num1 > 0 && num2 > 0;
		num1 ^= num2;
		int count = 0;
		while(num1 != 0) {
			if ((num1 & 1) == 1) {
				count++;
			}
			num1 >>>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		DiffBits solution = new DiffBits();
		
		int num1 = 1;
		int num2 = 2;
		System.out.println(solution.diffBits(num1, num2));
		
		num1 = Integer.MAX_VALUE;
		num2 = 127;
		System.out.println(solution.diffBits(num1, num2));
	}
}