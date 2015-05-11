/**
 * Given a target value of cents and a list of possible coins,
 * print all the combinations of coins, the sum value is the target.  
 * 
 */
public class WaysOfCoins {
	
	// Assumptions:
	// 1). the value of coins are sorted by descending order
	// 2). there are no duplicate values in the value of coins
	// 3). there is no 0 value in the coins
	public void ways(int target, int[] coins) {
		assert target >= 0 && coins != null && coins.length > 0;
		int[] solution = new int[coins.length];
		ways(target, coins, solution, 0);
	}
	
	// the value in solution array means how many coins we have
	// for the corresponding coin in the coins array.
	// For Example,
	// coins     = {25, 10, 5, 2, 1}
	// solution  = {  1,  2, 3, 4, 5}
	// means we have 1 x 25 cents coins, 2 x 10 cents coins, 3 x 5 cents coins,
	// 4 x 2 cents coins, 5 x 1 cent coins.
	private void ways(int target, int[] coins, int[] solution, int index) {
		if (index == coins.length - 1) {
			// early termination, the remainder of target divided by
			// the smallest coin must be 0 for a valid solution.
			if (target % coins[index] == 0) {
				solution[index] = target / coins[index];
				printSolution(coins, solution);
			}
			return;
		}
		// how many coins we can have for the current target.
		int maxNum = target / coins[index];
		for (int num = 0; num <= maxNum; num++) {
			solution[index] = num;
			ways(target - num * coins[index], coins, solution, index + 1);
		}
	}
	
	private void printSolution(int[] coins, int[] solution) {
		assert coins.length == solution.length;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < coins.length; i++) {
			builder.append("[").append(coins[i]).append(" cent coins: ")
				.append(solution[i]).append("] ");
		}
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) {
		WaysOfCoins solution = new WaysOfCoins();
		
		int[] coins = new int[] {25, 10, 5, 2, 1};
		int target = 0;
		solution.ways(target, coins);
		System.out.println("___________________________");
		
		target = 11;
		solution.ways(target, coins);
		System.out.println("___________________________");
		
		//target = 99;
		//solution.ways(target, coins);
		//System.out.println("___________________________");
	}
}
