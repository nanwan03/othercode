import java.util.*;
public class DisjointWhiteAreas {
	public int disjointWhiteAreas(int[][] matrix) {
		assert matrix != null && matrix.length > 0 && matrix[0].length > 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 2;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					findWhiteArea(matrix, i, j, count++);
				}
			}
		}
		return count - 2;
	}
	
	private void findWhiteArea(int[][] matrix, int i, int j, int count) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Queue<Point> queue = new LinkedList<Point>();
		matrix[i][j] = count;
		queue.offer(new Point(i, j));
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			int x = current.x;
			int y = current.y;
			if (x - 1 >= 0 && matrix[x - 1][y] == 0) {
				matrix[x - 1][y] = count;
				queue.offer(new Point(x - 1, y));
			}
			if (x + 1 < rows && matrix[x + 1][y] == 0) {
				matrix[x + 1][y] = count;
				queue.offer(new Point(x + 1, y));
			}
			if (y - 1 >= 0 && matrix[x][y - 1] == 0) {
				matrix[x][y - 1] = count;
				queue.offer(new Point(x, y - 1));
			}
			if (y + 1 < cols && matrix[1][y + 1] == 0) {
				matrix[x][y + 1] = count;
				queue.offer(new Point(x, y + 1));
			}
		}
	}
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		DisjointWhiteAreas solution = new DisjointWhiteAreas();
		
		int[][] matrix = new int[][] {
				{0, 0, 0, 1},
				{1, 0, 1, 1},
				{1, 1, 0, 0},
				{0, 1, 0, 0}
		};
		System.out.println(solution.disjointWhiteAreas(matrix));
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
