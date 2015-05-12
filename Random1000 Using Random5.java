public class Solution {
  public int random1000() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while (true) {
			int current = 0;
			for (int i = 0; i < 5; i++) {
				current = current * 5 + RandomFive.random5();
			}
			if (current < 3000) {
				return current % 1000;
			}
		}
  }
}