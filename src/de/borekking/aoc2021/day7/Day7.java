package de.borekking.aoc2021.day7;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day7 extends AbstractDay {

    private final List<Integer> crabs;
    private int max;

    public Day7() throws FileNotFoundException {
        super(7, "Day7.txt");

        this.crabs = new ArrayList<>();

        // Fill crabs list with every element if input and get the biggest element (max)
        for (String s : this.input.get(0).split(",")) {
            int i = Integer.parseInt(s);
            if (i > this.max) this.max = i;
            this.crabs.add(i);
        }
    }

    @Override
    public String solvePart1() {
        // Create array which holds the total needed steps (per index)
        long[] arr = new long[this.max+1];
        // Go from 0 to max (inclusive)
        for (int i = 0; i <= this.max; i++) {
            // Go through all crabs
            for (int crab : this.crabs) {
                // Add needed steps to current index (i) in arr
                arr[i] += Math.abs(crab-i);
            }
        }

        // Return the smallest element of arr
        return String.valueOf(getSmallest(arr));
    }

    @Override
    public String solvePart2() {
        // Create array which holds the total needed steps (per index)
        long[] arr = new long[this.max+1];
        // Go from 0 to max (inclusive)
        for (int i = 0; i <= this.max; i++) {
            // Go through all crabs
            for (int crab : this.crabs) {
                // Add needed steps to current index (i) in arr
                int steps = Math.abs(crab-i);
                arr[i] += sum(steps);
            }
        }

        // Return the smallest element of arr
        return String.valueOf(getSmallest(arr));
    }

    // Part 1 & 2
    private long getSmallest(long[] arr) {
        long lowest = arr[0];
        for (long l : arr)
            if (l < lowest)
                lowest = l;
        return lowest;
    }

    // Part 2
    private int sum(int n) {
        return (n * (n + 1)) / 2;
    }
}
