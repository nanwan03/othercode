public class Solution {
  public int maxDiff(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
        return 0;
    }
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int tempMin = Integer.MAX_VALUE;
    int tempMax = Integer.MIN_VALUE;
    int[] leftMin = new int[array.length];
    int[] leftMax = new int[array.length];
    for (int i = 0; i < array.length; i++) {
        tempMin = Math.min(tempMin, 0) + array[i];
        tempMax = Math.max(tempMax, 0) + array[i];
        min = Math.min(min, tempMin);
        max = Math.max(max, tempMax);
        leftMin[i] = min;
        leftMax[i] = max;
    }
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    tempMin = Integer.MAX_VALUE;
    tempMax = Integer.MIN_VALUE;
    int[] rightMin = new int[array.length];
    int[] rightMax = new int[array.length];
    for (int i = array.length - 1; i >= 0; i--) {
        rightMin[i] = min;
        rightMax[i] = max;
        tempMin = Math.min(tempMin, 0) + array[i];
        tempMax = Math.max(tempMax, 0) + array[i];
        min = Math.min(tempMin, min);
        max = Math.max(tempMax, max);
    }
    int rst = Integer.MIN_VALUE;
    for (int i = 0; i < array.length - 1; i++) {
        rst = Math.max(rst, Math.max(Math.abs(leftMax[i] - rightMin[i]), Math.abs(rightMax[i] - leftMin[i])));
    }
    return rst;
  }
}