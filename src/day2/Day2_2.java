package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int horizontal = 0  , depth = 0, aim = 0;

        while (scanner.hasNext()) {
            String ex = scanner.nextLine();
            String[] exs = ex.split(" ");
            int i = Integer.parseInt(exs[1]);

            switch(exs[0]) {
                case "forward":
                    horizontal += i;
                    depth += aim*i;
                    break;
                case "down":
                    aim += i;
                    break;
                case "up":
                    aim -= i;
                    break;
            }
        }

        System.out.println(horizontal * depth);
    }
}
