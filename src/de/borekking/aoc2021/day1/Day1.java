package de.borekking.aoc2021.day1;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Day1 extends AbstractDay {

    private final List<Integer> integerList;

    public Day1() throws FileNotFoundException {
        super(1, "Day1.txt");

        this.integerList = this.convertInputList(Integer::parseInt);
    }

    @Override
    public String solvePart1() {

        Integer last = null, count = 0;

        for (int i : this.integerList) {
            if (last != null && last < i)
                count++;
            last = i;
        }

        return String.valueOf(count);
    }

    @Override
    public String solvePart2() {
        int a = this.integerList.get(0), b = this.integerList.get(1), c = this.integerList.get(2), lastSum = a+b+c;
        int[] arr = new int[] {a, b, c};
        int count = 0;

        for (int i = 3; i < this.integerList.size(); i++) {
            int current = this.integerList.get(i);
            this.swap(arr, current);
            int newSum = this.sum(arr);

            if (lastSum < newSum) count++;

            lastSum = newSum;
        }

        return String.valueOf(count);
    }

    // Part 2
    private int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    // Part 2
    private void swap(int[] arr, int i) {
        arr[0] = arr[1];
        arr[1] = arr[2];
        arr[2] = i;
    }
}
