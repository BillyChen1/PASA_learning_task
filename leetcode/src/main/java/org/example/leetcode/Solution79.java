package org.example.leetcode;

public class Solution79 {
    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,1,-1};
    private String word;
    private boolean[][] used;
    private int row;
    private int col;

    /**
     * 单词搜索
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;

        this.word = word;
        used = new boolean[row][col];
        this.row = row;
        this.col = col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //(i,j)是搜索起点，index表示在word中的索引
    public boolean dfs(char[][] board, int i, int j, int index) {
        //出口
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }

        if (board[i][j] == word.charAt(index)) {
            used[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !used[newX][newY]) {
                    if (dfs(board, newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            used[i][j] = false;
        }
        return false;
    }
}
