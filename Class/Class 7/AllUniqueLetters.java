/**
 * Determine if the letters in a word are all unique.
 * Assumption:
 * We are using ASCII encoding and the number of valid letters
 * is 256, encoded from 0 to 255.
 */
public class AllUniqueLetters {

	public boolean allUniqueLetters(String word) {
		assert word != null;
		int[] vec = new int[256 / 32];
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			if ((vec[temp / 32] >>> (temp % 32) & 1) != 0) {
				return false;
			}
			vec[temp / 32] |= 1 << (temp % 32);
		}
		return true;
	}
	
	public static void main(String[] args) {
		AllUniqueLetters solution = new AllUniqueLetters();
		
		String word = "";
		System.out.println(solution.allUniqueLetters(word));
		
		word = "abcde";
		System.out.println(solution.allUniqueLetters(word));
		
		word = "abcaa";
		System.out.println(solution.allUniqueLetters(word));
	}
}
