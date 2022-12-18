package test.graphs;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class MaxAreaIslandTest {

    @Test
    public void TestMaxArea(){

        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
        
    }
    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        HashSet<Point> visited = new HashSet<>();
        Deque<Point> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for (int y  =0; y < grid.length; y++){

            for (int x = 0; x < grid[y].length; x++){

                Point p = new Point(x,y);

                if (grid[y][x] != 1 || visited.contains(p)){
                    continue;
                }

                int currentArea = 0;
                queue.add(p);
                visited.add(p);

                while (queue.size() > 0){

                    Point current = queue.poll();
                    currentArea++;
                    for (int[] dir : directions){
                        Point neighbor = new Point(current.x + dir[0], current.y+ dir[1]);
                        if (neighbor.x >=0 && neighbor.x < grid[0].length
                                && neighbor.y >=0 && neighbor.y < grid.length
                                && grid[neighbor.y][neighbor.x] == 1
                                && !visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }

                    ans = Math.max(currentArea,ans);
                }


            }
        }

        return ans;
    }
}
