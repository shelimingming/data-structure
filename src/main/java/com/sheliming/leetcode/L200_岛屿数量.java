package com.sheliming.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L200_岛屿数量 {
    /**
     * 深度优先搜索
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        int num_islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return num_islands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }


    /**
     * 宽度优先搜索
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        int num_islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                Queue<Node> queue = new LinkedList<Node>();

                if (grid[i][j] == '1') {
                    num_islands++;
                    grid[i][j] = '0';

                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();

                        if (node.x - 1 >= 0 && grid[node.x - 1][node.y] == '1') {
                            queue.add(new Node(node.x - 1, node.y));
                            grid[node.x - 1][node.y] = '0';
                        }
                        if (node.y + 1 < column && grid[node.x][node.y + 1] == '1') {
                            queue.add(new Node(node.x, node.y + 1));
                            grid[node.x][node.y + 1] = '0';
                        }
                        if (node.x + 1 < row && grid[node.x + 1][node.y] == '1') {
                            queue.add(new Node(node.x + 1, node.y));
                            grid[node.x + 1][node.y] = '0';
                        }
                        if (node.y - 1 >= 0 && grid[node.x][node.y - 1] == '1') {
                            queue.add(new Node(node.x, node.y - 1));
                            grid[node.x][node.y - 1] = '0';
                        }
                    }
                }

            }
        }


        return num_islands;
    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(new L200_岛屿数量().numIslands2(grid));
    }
}
