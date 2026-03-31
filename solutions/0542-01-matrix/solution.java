import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        //Initialize queue with all 0s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // mark unvisited
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries & unvisited
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    mat[newRow][newCol] == -1) {

                    mat[newRow][newCol] = mat[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }
}
