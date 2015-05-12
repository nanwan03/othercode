public class Solution {
  public List<Integer> closest(int[] array, int target) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (array == null || array.length == 0) {
      return rst;
    }
    Arrays.sort(array);
    int left = 0;
    int right = array.length - 1;
    int closet = 0;
    int c1 = 0;
    int c2 = 0;
    while (left < right) {
      int sum = array[left] + array[right];
      if (sum == target) {
        rst.add(array[left]);
        rst.add(array[right]);
        return rst;
      }
      if (Math.abs(sum - target) < Math.abs(closet - target)) {
        closet = sum;
        c1 = array[left];
        c2 = array[right];
      }
      if (sum > target) {
        right--;
      } else {
        left++;
      }
    }
    rst.add(c1);
    rst.add(c2);
    return rst;
  }
}