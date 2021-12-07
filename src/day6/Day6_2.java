package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day6_2 {

    /*
     * Good version
     *
     */

    private static int days = 256   ;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        String str = sc.nextLine();
        List<Integer> fish = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        long[] arr = new long[9];
        for (int e : fish)
            arr[e]++;

        for (int i = 0; i < days; i++) {
            int day = i % 9;
            arr[(day+7) % 9] += arr[day];
        }

        System.out.println(Arrays.stream(arr).sum());
    }
}
