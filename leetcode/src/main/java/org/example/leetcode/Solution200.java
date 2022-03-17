package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/13
 **/
public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int num = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    public void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;

        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }

        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x, y+1);
            dfs(grid, x, y-1);
            dfs(grid, x+1, y);
            dfs(grid, x-1, y);
        }
    }
}
