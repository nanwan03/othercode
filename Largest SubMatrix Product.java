public class Solution {
  public double largest(double[][] matrix) {
    // write your solution here
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    double max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < matrix.length; i++) {
      double[] temp = new double[matrix[i].length];
      Arrays.fill(temp, 1.0);
      for (int j = i; j < matrix.length; j++) {
        mulArray(temp, matrix[j]);
        max = Math.max(max, getMax(temp));
      }
    }
    return max;
  }
  private void mulArray(double[] array, double[] addition) {
    for (int i = 0; i < array.length; i++) {
      array[i] *= addition[i];
    }
  }
  private double getMax(double[] array) {
    double maxSoFar = 1.0;
    double minSoFar = 1.0;
    double max = Double.NEGATIVE_INFINITY;
    for (double i : array) {
      double tempMax = Math.max(Math.max(maxSoFar * i, minSoFar * i), i);
      double tempMin = Math.min(Math.min(maxSoFar * i, minSoFar * i), i);
      max = Math.max(max, tempMax);
      maxSoFar = tempMax;
      minSoFar = tempMin;
    }
    return max;
  }
}