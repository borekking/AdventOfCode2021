package de.borekking.aoc2021.day2;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;

public class Day2 extends AbstractDay {

    public Day2() throws FileNotFoundException {
        super(2, "Day2.txt");
    }

    @Override
    public String solvePart1() {
        int horizontal = 0  , depth = 0;

        for (String ex : this.input) {
            String[] exs = ex.split(" ");
            int i = Integer.parseInt(exs[1]);

            switch (exs[0]) {
                case "forward" -> horizontal += i;
                case "down" -> depth += i;
                case "up" -> depth -= i;
            }
        }

        return String.valueOf(horizontal * depth);
    }

    @Override
    public String solvePart2() {
        int horizontal = 0  , depth = 0, aim = 0;

        for (String ex : this.input) {
            String[] exs = ex.split(" ");
            int i = Integer.parseInt(exs[1]);

            switch (exs[0]) {
                case "forward" -> {
                    horizontal += i;
                    depth += aim * i;
                }
                case "down" -> aim += i;
                case "up" -> aim -= i;
            }
        }

        return String.valueOf(horizontal * depth);
    }
}
