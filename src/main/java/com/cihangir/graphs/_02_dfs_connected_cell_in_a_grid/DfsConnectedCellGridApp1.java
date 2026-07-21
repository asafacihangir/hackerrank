package com.cihangir.graphs._02_dfs_connected_cell_in_a_grid;

import java.util.List;

/***
 *  Algorithm findLargestRegion(grid):
 *     1. Initialize maxRegionSize to 0.
 *     2. Loop through each cell in the grid.
 *     3. If the cell is a 1, perform a Depth-First Search (DFS):
 *         a. Initialize a local regionSize to 1.
 *         b. Mark the cell as visited (by setting it to a special value, e.g., -1).
 *         c. Explore all possible 8 directions (up, down, left, right, and the four diagonals) around the current cell.
 *         d. For each direction, if the next cell is a 1 and has not been visited, recursively call DFS from that cell, adding to the regionSize.
 *     4. Compare the local regionSize with maxRegionSize, and update maxRegionSize if it's larger.
 *     5. After the loop, return maxRegionSize as the result.
 */

public class DfsConnectedCellGridApp1 {

  public static void main(String[] args) {

    int[][] grid = {
      {1, 1, 0, 0},
      {0, 1, 1, 0},
      {0, 0, 1, 0},
      {1, 0, 0, 0}
    };

    System.out.println(maxRegion(grid)); // Output should be 5

    System.out.println();
  }

  // Directions to move in the grid, represents 8 possible movements
  /**
   * {-1, -1}: Mevcut hücrenin sol üst çaprazına git (satırı ve sütunu birer azalt). {-1, 0}: Mevcut
   * hücrenin hemen üstüne git (yalnızca satırı bir azalt). {-1, 1}: Mevcut hücrenin sağ üst
   * çaprazına git (satırı bir azalt ve sütunu bir arttır). {0, -1}: Mevcut hücrenin soluna git
   * (yalnızca sütunu bir azalt). {0, 1}: Mevcut hücrenin sağında git (yalnızca sütunu bir arttır).
   * {1, -1}: Mevcut hücrenin sol alt çaprazına git (satırı bir arttır ve sütunu bir azalt). {1, 0}:
   * Mevcut hücrenin hemen altına git (yalnızca satırı bir arttır). {1, 1}: Mevcut hücrenin sağ alt
   * çaprazına git (hem satırı hem de sütunu birer arttır).
   */
  private static final int[][] directions = {
    {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
  };

  public static int maxRegion(int[][] grid) {
    int maxRegion = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          System.out.println(String.format("(i-j -> %s-%s", i, j));
          int size = dfs(grid, i, j);
          System.out.println(String.format("Size: %s", size));

          maxRegion = Math.max(maxRegion, size);
        }
      }
    }

    return maxRegion;
  }

  private static int dfs(int[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
      return 0;
    }

    grid[row][col] = 0; // mark the cell as visited

    System.out.println(String.format("İnner row-col: %s-%s", row, col));
    int size = 1; // current cell

    // Visit all 8 adjacent cells
    for (int[] direction : directions) {

      int newRow = row + direction[0];
      int newCol = col + direction[1];

      final int dfsResult = dfs(grid, newRow, newCol);
      System.out.println(
          String.format("dfs result => %s  Input: Row:%s Col:%s", dfsResult, newRow, newCol));

      size += dfsResult;
    }

    return size;
  }
}
