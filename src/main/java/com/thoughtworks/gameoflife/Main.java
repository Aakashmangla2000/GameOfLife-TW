package com.thoughtworks.gameoflife;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Coordinates> aliveCells = Arrays.asList(new Coordinates(1, 1), new Coordinates(1, 0), new Coordinates(1, 2));
        Universe universe = new Universe(aliveCells);

        Printer printer = new Printer(universe);
        printer.print();
        universe.tick();
        printer.print();
    }
}
