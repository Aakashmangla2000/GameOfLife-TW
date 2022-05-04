package com.thoughtworks.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    List<Coordinates> aliveCells;

    public Universe(List<Coordinates> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public List<Coordinates> tick() {
        List<Coordinates> newGeneration = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean alive = isAlive(i, j);
                if (alive) {
                    int neighbours = neighbours(i, j);
                    if (neighbours == 2 || neighbours == 3)
                        newGeneration.add(new Coordinates(i, j));
                } else {
                    if (neighbours(i, j) == 3)
                        newGeneration.add(new Coordinates(i, j));
                }
            }
        }
        this.aliveCells = newGeneration;
        return newGeneration;
    }


    private int neighbours(int i, int j) {
        int neighbours = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (isAlive(k, l) && (k != i || l != j) )
                    neighbours += 1;
            }
        }
        return neighbours;
    }

    public boolean isAlive(int i, int j) {
        return this.aliveCells.contains(new Coordinates(i, j));
    }
}
