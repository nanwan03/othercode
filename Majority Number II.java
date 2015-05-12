public class Solution {
  public List<Integer> majority(int[] array) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (array == null || array.length == 0) {
      return rst;
    }
    int candidate1 = 0;
    int candidate2 = 0;
    int count1 = 0;
    int count2 = 0;
    for (int i : array) {
      if (count1 == 0) {
        count1 = 1;
        candidate1 = i;
      } else if (count2 == 0) {
        count2 = 1;
        candidate2 = i;
      } else if (candidate1 == i) {
        count1++;
      } else if (candidate2 == i) {
        count2++;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int i : array) {
      if (candidate1 == i) {
        count1++;
      } else if (candidate2 == i) {
        count2++;
      }
    }
    if (count1 > array.length / 3) {
      rst.add(candidate1);
    }
    if (count2 > array.length / 3) {
      rst.add(candidate2);
    }
    return rst;
  }
}