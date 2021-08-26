package com.vkstech.algorithms.practice.graph;

import java.util.Vector;

/**
 * Knight Walk
 * Given a square chessboard, the initial position of Knight and position of a target.
 * Find out the minimum steps a Knight will take to reach the target position.
 * Note: The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.
 */
public class KnightWalk {

    public static class cell {
        int x, y;
        int dis;

        public cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    private static boolean isInside(int x, int y, int N) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    public static int minStepToReachTarget(int[] knightPos, int[] targetPos, int N) {
        // x and y direction, where a knight can move
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        Vector<cell> q = new Vector<>();
        q.add(new cell(knightPos[0], knightPos[1], 0));

        cell t;
        int x, y;
        boolean[][] visit = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;

        visit[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            t = q.firstElement();
            q.remove(0);

            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;

            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }

}