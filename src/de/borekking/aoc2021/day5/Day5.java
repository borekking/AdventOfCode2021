package de.borekking.aoc2021.day5;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 extends AbstractDay {

    private final List<Line> linesPart1, linesPart2;

    public Day5() throws FileNotFoundException {
        super(5, "Day5.txt");

        this.linesPart1 = this.getCustomInput(sc -> {
            String[] s = sc.nextLine().split(" -> ");
            return new Line(this.getCoordinate(s[0]), this.getCoordinate(s[1]), false);
        });

        this.linesPart2 = this.getCustomInput(sc -> {
            String[] s = sc.nextLine().split(" -> ");
            return new Line(this.getCoordinate(s[0]), this.getCoordinate(s[1]), true);
        });
    }

    @Override
    public String solvePart1() {
        Map<Coordinate, Integer> counter = new HashMap<>();
        for (Line l : this.linesPart1)
            for (Coordinate arr : l.getCoveringPoints())
                counter.put(arr, counter.getOrDefault(arr, 0) + 1);

        int count = 0;
        for (Coordinate key : counter.keySet())
            if (counter.get(key) >= 2)
                count++;

        return String.valueOf(count);
    }

    @Override
    public String solvePart2() {
        Map<Coordinate, Integer> counter = new HashMap<>();
        for (Line l : this.linesPart2)
            for (Coordinate arr : l.getCoveringPoints())
                counter.put(arr, counter.getOrDefault(arr, 0) + 1);

        int count = 0;
        for (Coordinate key : counter.keySet())
            if (counter.get(key) >= 2)
                count++;

        return String.valueOf(count);
    }

    // Part 1 & 2
    private Coordinate getCoordinate(String s) {
        String[] args = s.split(",");
        return new Coordinate(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
