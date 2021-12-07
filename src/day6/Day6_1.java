package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day6_1 {

    /*
     * Bad Version
     *
     */

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        String str = sc.nextLine();
        List<Integer> fish = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        for (int day = 0; day < 80; day++)
            updateFish(fish);

        System.out.println(fish.size());
    }

    private static void  updateFish(List<Integer> fish) {
        int newAmount = 0;

        for (int i = 0; i < fish.size(); i++) {
            int element = fish.get(i), newElement;
            if (element == 0) {
                newElement = 6;
                newAmount++;
            } else {
                newElement = element-1;
            }

            fish.set(i, newElement);
        }

        for (int i = 0; i < newAmount; i++)
            fish.add(8);
    }
}
