package com.vkstech.algorithms.practice3.queue;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1
public class GasStation {

    public static void main(String[] args) {
        int[] gas1 = {4, 5, 7, 4};
        int[] cost1 = {6, 6, 3, 5};
        System.out.println(startStation(gas1, cost1));

    }

    public static int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        Queue<Integer> q = new LinkedList<>();

        int start = 0;
        int tank = 0;
        int count = 0;
        int i = 0;

        while (start < n && count < n) {

            int idx = i % n;
            q.add(idx);
            tank += gas[idx] - cost[idx];
            count++;

            if (tank < 0) {
                while (!q.isEmpty()) q.poll();
                start++;
                i = start;
                tank = 0;
                count = 0;
                continue;
            }

            i++;
        }

        return (count == n) ? start : -1;
    }
}
