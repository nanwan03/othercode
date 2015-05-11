/**
 * Determine if a number is power of 2.
 */
public class PowerOfTwo {

	public boolean isPowerOfTwo(int number) {
		if (number <= 0) {
			return false;
		}
		
		while ((number & 1) == 0) {
			number >>>= 1;
		}
		return number == 1;
	}
	
	public static void main(String[] args) {
		PowerOfTwo solution = new PowerOfTwo();
		
		int number = -1;
		System.out.println(solution.isPowerOfTwo(number));
		
		number = 0;
		System.out.println(solution.isPowerOfTwo(number));
		
		number = 1;
		System.out.println(solution.isPowerOfTwo(number));
		
		number = 4;
		System.out.println(solution.isPowerOfTwo(number));
		
		number = 6;
		System.out.println(solution.isPowerOfTwo(number));
	}
}
