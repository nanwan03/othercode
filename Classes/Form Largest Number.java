public class Solution {
  class Cmp implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      String ab = a.concat(b);
      String ba = b.concat(a);
      return ba.compareTo(ab);
    }
  }
  public String largestNumber(String[] input) {
    // Write your solution here.
    if (input == null || input.length < 1) {
      return "";
    }
 
    Arrays.sort(input, new Cmp());
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; ++i) {
    	sb.append(input[i]);
    }
    
    String rst = sb.toString();
    int i = 0;
    while (i < input.length && rst.charAt(i) == '0') {
        i++;
    }
    if (i == input.length) {
      return "0";
    }
    return rst.substring(i);
  }
}
