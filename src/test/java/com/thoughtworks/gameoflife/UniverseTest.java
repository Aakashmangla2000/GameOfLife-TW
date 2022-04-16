package com.thoughtworks.gameoflife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class UniverseTest {
    @Test
    void lifeShouldRemainSameWhenBlockPatternIsGiven(){
        List<Coordinates> aliveCells = Arrays.asList(new Coordinates(1,1), new Coordinates(1,2), new Coordinates(2,1), new Coordinates(2,2));
        Universe universe = new Universe(aliveCells);
        List<Coordinates> newGeneration = universe.tick();

        assertThat(newGeneration, containsInAnyOrder(aliveCells.toArray()));
    }

    @Test
    void lifeShouldRemainSameWhenBoatPatternIsGiven(){
        List<Coordinates> aliveCells = Arrays.asList(new Coordinates(0,1), new Coordinates(1,0), new Coordinates(2,1), new Coordinates(0,2), new Coordinates(1,2));
        Universe universe = new Universe(aliveCells);
        List<Coordinates> newGeneration = universe.tick();

        assertThat(newGeneration, containsInAnyOrder(aliveCells.toArray()));
    }
}
