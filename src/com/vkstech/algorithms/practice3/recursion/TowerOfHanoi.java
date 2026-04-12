package com.vkstech.algorithms.practice3.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(4));
    }

    public static int towerOfHanoi(int n) {
        towerOfHanoi(n, 1, 2, 3);
        return (int) (Math.pow(2, n) - 1);
    }

    private static void towerOfHanoi(int n, int src, int help, int dest) {

        if (n == 1) {
            System.out.println("Moved disk " + n + " from " + src + " to " + dest);
            return;
        }

        // transfer n-1 disks to helper
        towerOfHanoi(n - 1, src, dest, help);

        // transfer nth disk to destination
        System.out.println("Moved disk " + n + " from " + src + " to " + dest);

        // transfer n-1 disks to destinations
        towerOfHanoi(n - 1, help, src, dest);

    }
}
