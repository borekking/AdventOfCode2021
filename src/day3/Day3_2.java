package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class Day3_2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        List<String> l = new ArrayList<>();
        while (scanner.hasNext())
            l.add(scanner.nextLine());

        String oxygen = getNumber(l, (c, counter) -> {
            int common = counter.getCommon(1);
            return Integer.parseInt(String.valueOf(c)) == common;
        }, 0);
        String CO2 = getNumber(l, (c, counter) -> {
            int common = counter.getUncommon(0);
            return Integer.parseInt(String.valueOf(c)) == common;
        }, 0);

        int oxygenV = Integer.parseInt(oxygen, 2), CO2V = Integer.parseInt(CO2, 2);
        System.out.println(oxygenV*CO2V);
    }

    private static Util getCommons(List<String> l, int digit) {
        Util counter = new Util();

        for (String s : l)
            increase(counter, s.charAt(digit));

        return counter;
    }

    private static void increase(Util counter, char c) {
        int v = Integer.parseInt(String.valueOf(c));
        boolean a = v == 0, b = v == 1;
        counter.increase(a, b);
    }

    private static String getNumber(List<String> l, BiPredicate<Character, Util> criteria, int digit) {
        if (l.size() == 1) return l.get(0);

        Util commons = getCommons(l, digit);

        List<String> rest = new ArrayList<>();
        for (String s : l)
            if (criteria.test(s.charAt(digit), commons))
                rest.add(s);

        return getNumber(rest, criteria, digit + 1);
    }
}
