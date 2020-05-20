package com.weizz5.code.leetCode.dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * @author weizz5
 * @date 2020/04/22
 */
public class NumIslands {

    public static void main(String[] args) {
        NumIslands solution2 = new NumIslands();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
//        int numIslands1 = solution2.numIslands(grid1);
        int numIslands1 = solution2.numIslandsMySelf(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution2.numIslandsMySelf(grid2);
        System.out.println(numIslands2);
    }

    private int rows;
    private int cols;

    public int numIslandsMySelf(char[][] grid) {
        // 定义行列值
        rows = grid.length;
        cols = grid[0].length;
        // 定义方向向量
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int res = 0;
        boolean[][] marked = new boolean[rows][cols];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !marked[i][j]) {
                    res++;
                    marked[i][j] = true;
                    ((LinkedList<Integer>) queue).addLast(i * cols + j);

                    while (!queue.isEmpty()) {

                        int value = ((LinkedList<Integer>) queue).pollFirst();
                        int newX = value / cols;
                        int newY = value % cols;
                        for (int k = 0; k < directions.length; k++) {
                            int directionX = newX + directions[k][0];
                            int directionY = newY + directions[k][1];

                            if (directionX >= 0 && directionX < rows
                                    && directionY >= 0 && directionY < cols
                                    && grid[directionX][directionY] == '1'
                                    && !marked[directionX][directionY]) {

                                marked[directionX][directionY] = true;
                                ((LinkedList<Integer>) queue).addLast(directionX * cols + directionY);
                            }
                        }

                    }
                }

            }

        }

        return res;
    }


    public int numIslands(char[][] grid) {
        //           x-1,y
        //  x,y-1    x,y      x,y+1
        //           x+1,y
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("      i:" + i + ",j:" + j);
                // 如果是岛屿中的一个点，并且没有被访问过
                // 从坐标为 (i,j) 的点开始进行广度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    // 小技巧：把坐标转换为一个数字
                    // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                    queue.addLast(i * cols + j);
                    // 注意：这里要标记上已经访问过
                    marked[i][j] = true;
                    System.out.println("marked count i:" + i + ",j:" + j);
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        // 得到 4 个方向的坐标
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            System.out.println("      newX:" + newX + ",newY:" + newY);
                            // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                // 而不是在出队列的时候再标记
                                // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                marked[newX][newY] = true;
                                System.out.println("marked newX:" + newX + ",newY:" + newY);
                            }
                        }
                    }
                }
            }

        }
        return count;
    }

    private boolean inArea(int x, int y) {
        // 等于号这些细节不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
