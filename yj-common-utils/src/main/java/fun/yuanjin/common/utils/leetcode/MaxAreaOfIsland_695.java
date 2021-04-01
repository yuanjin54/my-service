package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName MaxAreaOfIsland_695
 * @Description 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @Author yuanjin
 * @Date 2021-01-07 21:43
 * @Version 1.0
 */
public class MaxAreaOfIsland_695 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    static int c = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    c = 0;
                    dfs(i, j, grid);
                    System.out.println(c);
                    max = Math.max(max, c);
                }
            }
        }
        return max;
    }

    private static void dfs(int i, int j, int[][] grid) {
        boolean stop = i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] == 0;
        if (stop) {
            return;
        }
        c++;
        grid[i][j] = 0;
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

    private static void print(int[][] grid) {
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-------------------");
    }

    public static int maxAreaOfIsland1(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs1(i, j, grid));
                }
            }
        }
        return max;
    }

    private static int dfs1(int i, int j, int[][] grid) {
        boolean stop = i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] == 0;
        if (stop) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs1(i - 1, j, grid) +
                dfs1(i + 1, j, grid) +
                dfs1(i, j - 1, grid) +
                dfs1(i, j + 1, grid);
    }
}
