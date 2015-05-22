/* 
* class Pair {
*   public int first;
*   public int second;
*   public Pair(int first, int second) {
*     this.first = first;   
*     this.second = second;
* }
*/
public class Solution {
  public Pair largestAndSmallest(int[] array) {
    // write your solution here
    // return a Pair object, the field first is the largest
    // and field second is the smallest.
    if (array == null || array.length == 0) {
      return null;
    }
    List<Integer> large = new ArrayList<Integer>();
    List<Integer> small = new ArrayList<Integer>();
    for (int i = 0; i < array.length; i = i + 2) {
      if (i == array.length - 1) {
        large.add(array[i]);
        small.add(array[i]);
      } else {
        large.add(Math.max(array[i], array[i + 1]));
        small.add(Math.min(array[i], array[i + 1]));
      }
    }
    return new Pair(findLarge(large), findSmall(small));
  }
  private int findLarge(List<Integer> list) {
    int max = Integer.MIN_VALUE;
    for (int i : list) {
      max = Math.max(i, max);
    }
    return max;
  }
  private int findSmall(List<Integer> list) {
    int min = Integer.MAX_VALUE;
    for (int i : list) {
      min = Math.min(min, i);
    }
    return min;
  }
}