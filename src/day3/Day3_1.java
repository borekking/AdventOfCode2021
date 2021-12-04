package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3_1 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        if (!scanner.hasNext()) return;
        String str = scanner.nextLine();
        int digits = str.length();

        Util[] counts = new Util[digits];
        for (int i = 0; i < digits; i++)
            counts[i] = new Util();

        increase(counts, str, digits);

        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            increase(counts, str1, digits);
        }

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            Util u = counts[i];
            gamma.append(u.getCommon());
            epsilon.append(u.getUncommon());
        }

        int gammaV = Integer.parseInt(gamma.toString(), 2), epsilonV = Integer.parseInt(epsilon.toString(), 2);

        System.out.println(gamma + ", " + epsilon);
        System.out.println(gammaV + ", " + epsilonV);
        System.out.println(gammaV * epsilonV);
    }

    private static void increase(Util[] counts, String s, int digits) {
        for (int i = 0; i < digits; i++) {
            char c = s.charAt(i);
            int v = Integer.parseInt(String.valueOf(c));
            boolean a = v == 0, b = v == 1;
            counts[i].increase(a, b);
        }
    }
}
