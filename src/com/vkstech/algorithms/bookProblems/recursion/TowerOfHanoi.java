package com.vkstech.algorithms.bookProblems.recursion;

public class TowerOfHanoi {

    public static void toh(int n, char fromTower, char toTower, char auxTower){
        if (n == 1){
            System.out.println("Move disk 1 from tower " + fromTower + " to tower " + toTower);
            return;
        }
        toh(n-1, fromTower, auxTower, toTower); // move top n-1 disks from A to B using C as auxiliary
        System.out.println("Move disk " + n + " from tower " + fromTower + " to tower " + toTower);
        toh(n-1, auxTower, toTower, fromTower); // move n-1 disks from B to C using A as aux
    }

    public static void main(String[] args) {
        toh(5, 'A', 'C', 'B');
    }
}
