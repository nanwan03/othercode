public class Solution {
  
	private int counter;
	private Integer random;
	
  public Solution() {
    // write your constructor code here if necessary
    counter = 0;
		random = null;
  }
  
  public void read(int value) {
    // write your implementation here
    counter++;
		if ((int)(Math.random() * counter) == 0) {
			random = value;
		}
  }
  
  public Integer sample() {
    // write your implementation here
    return random;
  }
}