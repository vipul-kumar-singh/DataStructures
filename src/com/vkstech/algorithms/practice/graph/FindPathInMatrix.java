package com.vkstech.algorithms.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find whether path exist
 * Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
 * The description of cells is as follows:
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Wall.
 * Note: There are only a single source and a single destination.
 */
public class FindPathInMatrix {

    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 3, 0, 0},
                {3, 0, 0, 0, 3},
                {3, 3, 3, 3, 3},
                {0, 2, 3, 3, 0},
                {3, 0, 0, 1, 3}};

        System.out.println(checkPathExist(grid));
    }

    public static class BFSElement {
        int i, j;

        BFSElement(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean checkPathExist(int[][] grid) {
        Queue<BFSElement> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i][j] == 1) {
                    queue.add(new BFSElement(i, j));
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            BFSElement x = queue.peek();
            queue.remove();
            int i = x.i;
            int j = x.j;

            if (i < 0 || i >= grid.length || j < 0 || j >= grid.length)
                continue;

            if (grid[i][j] == 0)
                continue;

            if (grid[i][j] == 2)
                return true;

            // marking as wall upon successful visitation
            grid[i][j] = 0;

            // pushing all adjacent elements to queue
            queue.add(new BFSElement(i, j + 1));
            queue.add(new BFSElement(i, j - 1));
            queue.add(new BFSElement(i + 1, j));
            queue.add(new BFSElement(i - 1, j));
        }

        return false;
    }

}
