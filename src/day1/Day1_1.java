package day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day1_1 {

    /*
     * see: https://adventofcode.com/2021
     *
     */

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        Integer last = null, count = 0;
        while (scanner.hasNext()) {
            int i = scanner.nextInt();

            if (last != null && last < i)
                count++;

            last = i;
        }

        System.out.println(count);
    }
}
