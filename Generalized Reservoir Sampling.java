public class Solution {
  private int k;
  private int counter;
	private List<Integer> rst;
	
  public Solution(int k) {
    // complete the constructor if necessary
    this.k = k;
    counter = 0;
    rst = new ArrayList<Integer>();
  }
  
  public void read(int value) {
    // write your implementation here
    counter++;
    if (counter <= k) {
      rst.add(value);
    } else {
      if ((int)(Math.random() * counter) == (counter - k)) {
        Random r = new Random();
			  int index = r.nextInt(k);
			  rst.set(index, value);
		  }
    }
  }
  
  public List<Integer> sample() {
    // write your implementation here
    return rst;
  }
}