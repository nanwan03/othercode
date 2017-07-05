import Solution.Direction;

public class Solution {
  private static enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);
    int deltaX = 0;
    int deltaY = 0;
    Direction(int deltaX, int deltaY) {
      this.deltaX = deltaX;
      this.deltaY = deltaY;
    }
    public int moveX(int x) {
      return this.deltaX + x;
    }
    public int moveY(int y) {
      return this.deltaY + y;
    }
  }
  public int[][] maze(int n) {
    if (n == 0 || n % 2 == 0) {
      return null;
    }
    int[][] maze = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maze[i][j] = 1;
      }
    }
    maze[0][0] = 0;
    generateRandomMaze(maze, 0, 0);
    return maze;
  }
  private void generateRandomMaze(int[][] maze, int x, int y) {
    Direction[] dirs = getRandomDirections();
    for (Direction dir : dirs) {
      int nx = dir.moveX(dir.moveX(x));
      int ny = dir.moveY(dir.moveY(y));
      if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 1) {
        maze[nx][ny] = 0;
        maze[dir.moveX(x)][dir.moveY(y)] = 0;
        generateRandomMaze(maze, nx, ny);
      }
    }
  }
  private Direction[] getRandomDirections() {
    Direction[] dirs = Direction.values();
    for (int i = dirs.length - 1; i >= 0; i--) {
      int r = (int)(Math.random() * (i + 1));
        Direction temp = dirs[r];
        dirs[r] = dirs[i];
        dirs[i] = temp;

    }
    return dirs;
  }
}