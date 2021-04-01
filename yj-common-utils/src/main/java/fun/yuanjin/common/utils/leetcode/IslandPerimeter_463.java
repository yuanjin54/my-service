package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName IslandPerimeter_463
 * @Description 463. 岛屿的周长
 * @Author yuanjin
 * @Date 2021-01-07 23:09
 * @Version 1.0
 */
public class IslandPerimeter_463 {
    public static void main(String[] args) {
        int[][] grid = {{1}};
//        int[][] grid = {{1}};
        System.out.println(islandPerimeter1(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    c = dfs(i, j, grid);
                }
            }
        }
        return c;
    }

    private static int dfs(int i, int j, int[][] grid) {
        boolean stop = i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1;
        if (stop) {
            return 0;
        }
        int c = 0;
        if (i - 1 < 0 || grid[i - 1][j] == 0) {
            c++;
        }
        if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
            c++;
        }
        if (j - 1 < 0 || grid[i][j - 1] == 0) {
            c++;
        }
        if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) {
            c++;
        }
        grid[i][j] = 2;
        return c + dfs(i - 1, j, grid) +
                dfs(i + 1, j, grid) +
                dfs(i, j - 1, grid) +
                dfs(i, j + 1, grid);
    }

    private static int perimeter = 0;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static int islandPerimeter1(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs1(grid, i, j);
                    return perimeter;
                }
            }
        }
        return 0;
    }

    private static void dfs1(int[][] grid, int i, int j) {
        //递归终止条件
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length-1 || grid[i][j] != 1) {
            return;
        }

        //处理本层
        perimeter += 4;
        grid[i][j] = -1;
        //若当前元素上下左右四个相邻元素有不为0的，周长减1
        for (int k = 0; k < dx.length; k++) {
            if (i + dx[k] >= 0 && i + dx[k] < grid.length && j + dy[k] >= 0 && j + dy[k] < grid[0].length) {
                if (grid[i + dx[k]][j + dy[k]] != 0) {
                    perimeter--;
                }
            }
        }

        //下探到下一层
        for (int k = 0; k < dx.length; k++) {
            dfs1(grid, i + dx[k], j + dy[k]);
        }
    }

}
