package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName Solve_130
 * @Description 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 * @Author yuanjin
 * @Date 2021-01-07 20:59
 * @Version 1.0
 */
public class Solve_130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    /**
     * 思路：
     * 1、先找出与边界上'O'相连的所有'O'位置
     * 2、遍历board，出去1中找出的'O'的位置不变以外，其他'O'的位置变为'X'即可。
     */
    public static void solve(char[][] board) {
        int h = board.length;
        if (h <= 1) {
            return;
        }
        int w = board[0].length;
        for (int i = 0; i < h; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][w - 1] == 'O') {
                dfs(i, w - 1, board);
            }
        }
        for (int i = 0; i < w; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[h - 1][i] == 'O') {
                dfs(h - 1, i, board);
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int i, int j, char[][] board) {
        boolean stop = i < 0 || j < 0 ||
                i >= board.length || j >= board[0].length ||
                board[i][j] == 'X' || board[i][j] == 'B';
        if (stop) {
            return;
        }
        board[i][j] = 'B';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }
}
