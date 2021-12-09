package de.borekking.aoc2021.day5;

import java.util.Arrays;
import java.util.Objects;

public class Coordinate {

    private final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return Arrays.toString(getAsArray());
    }

    public int[] getAsArray() {
        return new int[] {x, y};
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
