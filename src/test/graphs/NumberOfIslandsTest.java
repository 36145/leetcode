package test.graphs;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class NumberOfIslandsTest {

    @Test
    public void TestNumberOfIslands() {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));

    }

    public int numIslands(char[][] grid) {

        HashMap<Point, Boolean> visited = new HashMap<>();

        int ans = 0;

        Deque<Point> neighbors = new ArrayDeque<>();
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {

                Point coords = new Point(x,y);
                if (visited.containsKey(coords)) {
                    continue;
                }

                if (grid[y][x] == '1') {
                    ans++;
                    neighbors.add(coords);
                    visited.put(coords, true);
                    while (neighbors.size() > 0) {

                        Point current = neighbors.poll();
                        for (int[] dir : directions) {
                            int currentY = current.y + dir[0];
                            int currentX = current.x + dir[1];

                            Point neighbor = new Point(currentX,currentY);
                            if ((currentY >= 0) && (currentY < grid.length) &&
                                    (currentX >= 0) && (currentX < grid[0].length) &&
                                    (grid[currentY][currentX] == '1') && !visited.containsKey(neighbor)) {
                                visited.put(neighbor,true);
                                neighbors.add(neighbor);
                            }
                        }
                    }
                }


            }
        }

        return ans;
    }


}
