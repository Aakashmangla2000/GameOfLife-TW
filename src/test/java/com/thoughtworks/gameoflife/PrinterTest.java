package com.thoughtworks.gameoflife;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void shouldPrintWhenUniverseIsGiven() {
        List<Coordinates> aliveCells = Arrays.asList(new Coordinates(1, 1), new Coordinates(1, 0), new Coordinates(1, 2));
        Universe universe = new Universe(aliveCells);

        Printer printer = new Printer(universe);
        printer.print();
        String expected = "\nXXXXX\n" +
                "OOOXX\n" +
                "XXXXX\n" +
                "XXXXX\n" +
                "XXXXX\n";
        assertEquals(expected, outContent.toString());
    }
}
