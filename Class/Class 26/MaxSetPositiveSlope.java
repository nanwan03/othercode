import java.util.*;

/**
 * Given an array of coordinates of points, how to find the
 * largest number of points that can form a set such that
 * for any pair of points in the set can form a line with positive slope.
 */
public class MaxSetPositiveSlope {
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int maxSet(Point[] points) {
		assert points != null && points.length >= 1;
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x == p2.x) {
					return p1.y - p2.y;
				} else {
					return p1.x - p2.x;
				}
			}
		});
		int[] maxSet = new int[points.length];
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			maxSet[i] = 1;
			for (int j = 0; j < i; j++) {
				if (points[j].x < points[i].x && points[j].y < points[i].y) {
					maxSet[i] = Math.max(maxSet[i], 1 + maxSet[j]);
				}
				result = Math.max(result, maxSet[i]);
			}
		}
		return result > 1 ? result : 0;
	}
	
	public static void main(String[] args) {
		MaxSetPositiveSlope solution = new MaxSetPositiveSlope();
		
		Point[] points = new Point[] {new Point(1, 1), new Point(2, 0), new Point(1, 1)};
		System.out.println(solution.maxSet(points));
		
		points = new Point[] {new Point(0, 0), new Point(1, 1), new Point(2, 0), new Point(2, 3), new Point(3, 1)};
		System.out.println(solution.maxSet(points));
	}
}
