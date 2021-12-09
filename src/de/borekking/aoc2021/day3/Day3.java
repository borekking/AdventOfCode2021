package de.borekking.aoc2021.day3;

import de.borekking.aoc2021.AbstractDay;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Day3 extends AbstractDay {

    public Day3() throws FileNotFoundException {
        super(3, "Day3.txt");
    }

    @Override
    public String solvePart1() {
        String str = this.input.get(0);
        int digits = str.length();

        Util[] counts = new Util[digits];
        for (int i = 0; i < digits; i++)
            counts[i] = new Util();

        this.increase(counts, str, digits);

        for (String str1 : this.getSubInputList(1))
            increase(counts, str1, digits);

        StringBuilder gamma = new StringBuilder(), epsilon = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            Util u = counts[i];
            gamma.append(u.getCommon());
            epsilon.append(u.getUncommon());
        }

        int gammaV = Integer.parseInt(gamma.toString(), 2), epsilonV = Integer.parseInt(epsilon.toString(), 2);
        return String.valueOf(gammaV * epsilonV);
    }

    @Override
    public String solvePart2() {
        String oxygen = this.getNumber(this.input, (c, counter) -> {
            int common = counter.getCommon(1);
            return Integer.parseInt(String.valueOf(c)) == common;
        }, 0);
        String CO2 = this.getNumber(this.input, (c, counter) -> {
            int common = counter.getUncommon(0);
            return Integer.parseInt(String.valueOf(c)) == common;
        }, 0);

        int oxygenV = Integer.parseInt(oxygen, 2), CO2V = Integer.parseInt(CO2, 2);
        return String.valueOf(oxygenV*CO2V);
    }

    // Part 1
    private void increase(Util[] counts, String s, int digits) {
        for (int i = 0; i < digits; i++) {
            char c = s.charAt(i);
            int v = Integer.parseInt(String.valueOf(c));
            boolean a = v == 0, b = v == 1;
            counts[i].increase(a, b);
        }
    }

    // Part 2
    private String getNumber(List<String> l, BiPredicate<Character, Util> criteria, int digit) {
        if (l.size() == 1) return l.get(0);

        Util commons = this.getCommons(l, digit);

        List<String> rest = new ArrayList<>();
        for (String s : l)
            if (criteria.test(s.charAt(digit), commons))
                rest.add(s);

        return getNumber(rest, criteria, digit + 1);
    }

    // Part 2
    private Util getCommons(List<String> l, int digit) {
        Util counter = new Util();

        for (String s : l)
            this.increase(counter, s.charAt(digit));

        return counter;
    }

    // Part 2
    private void increase(Util counter, char c) {
        int v = Integer.parseInt(String.valueOf(c));
        boolean a = v == 0, b = v == 1;
        counter.increase(a, b);
    }
}
