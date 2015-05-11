import java.util.*;

/**
 * A dictionary of words, find the largest product of any two words
 * such that there is no common characters in the two words.
 * Assumption:
 * The only characters used in the words are 'a' - 'z'. 
 */
public class LargestProduct {

	public int largestProduct(List<String> dictionary) {
		assert dictionary != null && dictionary.size() >= 2;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : dictionary) {
			assert word != null;
			map.put(word, bitMap(word));
		}
		Collections.sort(dictionary, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		});
		
		int largest = 0;
		for (int i = 1; i < dictionary.size(); i++) {
			for (int j = 0; j < i; j++) {
				int leni = dictionary.get(i).length();
				int lenj = dictionary.get(j).length();
				if (leni * lenj < largest) {
					break;
				}
				int bi = map.get(dictionary.get(i));
				int bj = map.get(dictionary.get(j));
				if ((bi & bj) == 0) {
					largest = Math.max(largest, leni * lenj);
				}
			}
		}
		return largest;
	}
	
	private int bitMap(String word) {
		int bitMap = 0;
		for (int i = 0 ; i < word.length(); i++) {
			char current = word.charAt(i);
			bitMap |= 1 << (current - 'a');
		}
		return bitMap;
	}
	
	public static void main(String[] args) {
		LargestProduct solution = new LargestProduct();
		
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("abcd");
		dictionary.add("defg");
		dictionary.add("eyz");
		dictionary.add("abx");
		dictionary.add("hg");
		System.out.println(solution.largestProduct(dictionary));
	}
}
