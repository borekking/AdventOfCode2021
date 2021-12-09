package de.borekking.aoc2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractDay {

    private final int day;
    protected final List<String> input;
    private final File file;

    public AbstractDay(int day, String fileName) throws FileNotFoundException {
        this.day = day;
        this.input = new ArrayList<>();

        this.file = new File("src\\inputs\\" + fileName);
        Scanner scanner = new Scanner(this.file);

        while (scanner.hasNext()) this.input.add(scanner.nextLine());
    }

    public abstract String solvePart1();

    public abstract String solvePart2();

    public void print() {
        System.out.println("Day: " + this.day);
        System.out.println("Part 1: " + this.solvePart1());
        System.out.println("Part 2: " + this.solvePart2());
    }

    public <T> List<T> getCustomInput(int skips, Function<Scanner, T> mapper) {
        Scanner scanner;
        try {
            scanner = new Scanner(this.file);
        } catch (FileNotFoundException ignored) {
            return new ArrayList<>();
        }

        List<T> list = new ArrayList<>();
        for (int i = 0; i < skips; i++)
            scanner.nextLine();
        while (scanner.hasNext())
            list.add(mapper.apply(scanner));

        return list;
    }

    public <T> List<T> getCustomInput(Function<Scanner, T> mapper) {
        return this.getCustomInput(0, mapper);
    }

    public <T> List<T> convertInputList(Function<String, T> mapper) {
        return this.input.stream().map(mapper).collect(Collectors.toList());
    }

    public List<String> getSubInputList(int from, int to) {
        return this.input.subList(from, to);
    }

    public List<String> getSubInputList(int from) {
        return this.getSubInputList(from, this.input.size());
    }
}
