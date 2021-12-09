package de.borekking.aoc2021.day6;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 extends AbstractDay {

    private final List<Integer> fish;

    public Day6() throws FileNotFoundException {
        super(6, "Day6.txt");
        this.fish = Arrays.stream(this.input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public String solvePart1() {
        return String.valueOf(simulate(80));
    }

    @Override
    public String solvePart2() {
        return String.valueOf(simulate(256));
    }

    // Part 1 & 2
    private long simulate(int days) {
        long[] arr = new long[9];
        for (int e : this.fish)
            arr[e]++;

        for (int i = 0; i < days; i++) {
            int day = i % 9;
            arr[(day+7) % 9] += arr[day];
        }

        return Arrays.stream(arr).sum();
    }
}
