public class Solution {
  public String hex(int number) {
	  if (number == 0) {
		  return "0x0";
	  }
	  long input = (long)(number);
	StringBuilder sb = new StringBuilder();
    String prefix = "0x";
    while (input > 0) {
    	long index = input % 16;
    	input /= 16;
    	if (index <= 9) {
    		sb.append((char)('0' + index));
    	} else {
    		sb.append((char)('A' + index - 10));
    	}
    }
    return prefix + sb.reverse().toString();
  }
}