package test.dp;

import org.testng.annotations.Test;

public class UniquePaths {

    @Test
    public void TestUnique(){

        uniquePaths(3,7);
    }

    public int uniquePaths(int m, int n) {


        int[][] grid = new int[m][n];

        grid[m-1][n-1] = 1;

        for (int x = m -1; x >=0; x--){
            for(int y = n -1 ; y>=0; y--){
                if (x == m-1 && y == n-1){
                    continue;
                }

                int right = 0;
                int bottom = 0;

                if (x+1 < m){
                    right = grid[x+1][y];
                }
                if (y+1 < n ){
                    bottom = grid[x][y+1];
                }

                grid[x][y] = right+ bottom;

            }
        }


        return grid[0][0];
    }
}
