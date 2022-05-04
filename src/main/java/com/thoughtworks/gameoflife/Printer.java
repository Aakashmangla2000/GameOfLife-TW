package com.thoughtworks.gameoflife;

public class Printer {
    Universe universe;
    Printer(Universe universe) {
        this.universe = universe;
    }

    public void print() {
        System.out.print("\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean alive = universe.isAlive(i,j);
                if (alive) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print("\n");
        }
    }
}