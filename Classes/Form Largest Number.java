public class Solution {
  private class Cmp implements Comparator<String> {
    public int compare(String a, String b) {
      return (b + a).compareTo(a + b);
    }
  }
  public String largestNumber(String[] input) {
    // Write your solution here.
    if (input == null || input.length == 0) {
      return "";
    }
    Arrays.sort(input, new Cmp());
    StringBuilder sb = new StringBuilder();
    for (String str : input) {
      sb.append(str);
    }
    int i = 0;
    for (i = 0; i < sb.length() && sb.charAt(i) == '0'; ++i){}
    if (i == sb.length()) {
        return "0";
    } else {
        return sb.substring(i);
    }
  }
}
