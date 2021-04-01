package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName NumIslands_200
 * @Description 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @Author yuanjin
 * @Date 2021-01-07 14:42
 * @Version 1.0
 */
public class NumIslands_200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    searchIsland(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void searchIsland(int i, int j, char[][] grid) {
        // 递归终止条件
        boolean stop = i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0';
        if (stop) {
            return;
        }
        // 处理当前层
        grid[i][j] = '0';
        // 下探到下一层
        searchIsland(i - 1, j, grid);
        searchIsland(i, j - 1, grid);
        searchIsland(i + 1, j, grid);
        searchIsland(i, j + 1, grid);
        // 清理当前层
    }
}
