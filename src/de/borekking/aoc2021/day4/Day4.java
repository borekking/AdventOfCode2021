package de.borekking.aoc2021.day4;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4 extends AbstractDay {

    private final List<Field> fields;
    private final int[] numbers;

    public Day4() throws FileNotFoundException {
        super(4, "Day4.txt");

        this.fields = this.getCustomInput(1, this::getField);
        this.numbers = this.getNumbers(this.input.get(0));
    }

    @Override
    public String solvePart1() {
        int result = -1;

        Outer:
        for (int current : this.numbers) {
            for (Field field : this.fields)
                field.add(current);

            for (Field field : this.fields) {
                if (field.bingo()) {
                    result = field.getUnmarkedSum() * current;
                    break Outer;
                }
            }
        }
        
        return String.valueOf(result);
    }

    @Override
    public String solvePart2() {
        boolean[] checkedFields = new boolean[this.fields.size()];
        int result = -1;

        Outer:
        for (int current : this.numbers) {
            for (int i = 0; i < this.fields.size(); i++) {
                if (checkedFields[i]) continue;

                this.fields.get(i).add(current);
            }

            for (int i = 0; i < this.fields.size(); i++) {
                if (checkedFields[i]) continue;

                Field field = this.fields.get(i);
                if (field.bingo()) checkedFields[i] = true;

                if (allTrue(checkedFields)) {
                    result = field.getUnmarkedSum() * current;
                    break Outer;
                }
            }
        }

        return String.valueOf(result);
    }

    // Part 1 & 2
    private int[] getNumbers(String s) {
        return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    // Part 1 & 2
    private Field getField(Scanner sc) {
        int[][] numbers = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                numbers[i][j] = sc.nextInt();
        return new Field(numbers);
    }

    // Part 2
    private static boolean allTrue(boolean[] arr) {
        for (boolean b : arr)
            if (!b) return false;
        return true;
    }
}
