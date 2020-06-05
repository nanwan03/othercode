public class Solution {
  public int canWin(int[] nums) {
    // Write your solution here
	  return strategy(nums, 0, nums.length - 1);
  }
  public int strategyB(int[] nums, int start, int end) {
	  if (start == end) {
		  return 0;
	  }
	  if (nums[start] == nums[end]) {
		  return strategy(nums, start, end - 1);
	  } else {
		  return nums[start] > nums[end] ? strategy(nums, start + 1, end) : strategy(nums, start, end - 1);
	  }
  }
  public int strategy(int[] nums, int start, int end) {
	  if (start == end) {
		  return nums[start];
	  }
	  int a = nums[start] + strategyB(nums, start + 1, end);
	  int b = nums[end] + strategyB(nums, start, end - 1);
	  return Math.max(a, b);
  }
}
