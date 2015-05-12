public class Solution {
  public int random7() {
    while (true) {
			int current = RandomFive.random5() * 5 + RandomFive.random5();
			if (current < 21) {
				return current % 7;
			}
		}
  }
}