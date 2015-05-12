public class Solution {
  public double largestProduct(double[] array) {
    // write your solution here
    double maxSoFar = 1.0;
    double minSoFar = 1.0;
    double max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < array.length; i++) {
      double tempMax = Math.max(Math.max(maxSoFar * array[i], minSoFar * array[i]), array[i]);
      double tempMin = Math.min(Math.min(maxSoFar * array[i], minSoFar * array[i]), array[i]);
      max = Math.max(max, tempMax);
      maxSoFar = tempMax;
      minSoFar = tempMin;
    }
    return max;
  }
}