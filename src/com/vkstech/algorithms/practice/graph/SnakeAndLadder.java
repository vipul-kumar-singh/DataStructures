package com.vkstech.algorithms.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Snake and Ladder Problem
 * Given a 5x6 snakes and ladders board, find the minimum number of dice throws
 * required to reach the last cell from the 1st cell.
 * You are given an integer N denoting the total number of snakes and ladders and
 * an array arr[] of 2*N size where 2*i and (2*i + 1)th values denote the
 * starting and ending point respectively of ith snake or ladder.
 * The board looks like the following:
 * https://media.geeksforgeeks.org/wp-content/uploads/snake-and-ladders.jpg
 */
public class SnakeAndLadder {

    public static class qEntry {
        int v;
        int distance;
    }

    public static int getMinDiceThrows(int[] move, int n) {
        int[] visited = new int[n];
        Queue<qEntry> q = new LinkedList<>();
        qEntry qe = new qEntry();
        qe.v = 0;
        qe.distance = 0;

        visited[0] = 1;
        q.add(qe);

        while (!q.isEmpty()) {
            qe = q.remove();
            int v = qe.v;

            if (v == n - 1)
                break;

            for (int j = v + 1; j <= (v + 6) && j < n; ++j) {
                if (visited[j] == 0) {
                    qEntry a = new qEntry();
                    a.distance = (qe.distance + 1);
                    visited[j] = 1;

                    a.v = move[j] != -1 ? move[j] : j;
                    q.add(a);
                }
            }
        }

        return qe.distance;
    }

    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int N = 30;
        int[] moves = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
    }
}